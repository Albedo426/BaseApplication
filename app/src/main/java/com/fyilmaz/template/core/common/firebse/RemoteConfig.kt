package com.fyilmaz.template.core.common.firebse

import android.app.Activity
import android.content.Intent
import android.net.Uri
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.callbacks.onCancel
import com.fyilmaz.template.BuildConfig
import com.fyilmaz.template.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import java.util.*

class RemoteConfig(val minimumFetchIntervalInSeconds: Long, val activity: Activity, val success: () -> Unit) {
    private lateinit var mRemoteConfig: FirebaseRemoteConfig
    init {
        val mRemoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = this@RemoteConfig.minimumFetchIntervalInSeconds
        }
        mRemoteConfig.setConfigSettingsAsync(configSettings)
        mRemoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
    }
    fun startConfig() {
        mRemoteConfig.fetchAndActivate()
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    var maintenanceMessage = ""
                    var forceUpdateMessage = ""
                    var optionalMessage = ""
                    if ("tr_tr" != Locale.getDefault().toString()) {
                        maintenanceMessage = mRemoteConfig.getString("maintenanceMessageEN")
                        forceUpdateMessage = mRemoteConfig.getString("forceUpdateMessageEN")
                        optionalMessage = mRemoteConfig.getString("optionalUpdateMessageEN")
                    } else {
                        maintenanceMessage = mRemoteConfig.getString("maintenanceMessageTR")
                        forceUpdateMessage = mRemoteConfig.getString("forceUpdateMessageTR")
                        optionalMessage = mRemoteConfig.getString("optionalUpdateMessageTR")
                    }
                    val androidMarketURL = mRemoteConfig.getString("androidMarketURL")
                    val isMaintenanceAndroid = mRemoteConfig.getBoolean("isMaintenanceAndroid")
                    val androidRequiredVersion = mRemoteConfig.getLong("androidRequiredVersion")
                    val androidOptionalVersion = mRemoteConfig.getLong("androidOptionalVersion")

                    val versionCode = BuildConfig.VERSION_CODE
                    if (androidRequiredVersion > versionCode) {
                        showAlertDialog(activity.getString(R.string.system), forceUpdateMessage, AlertType.ForceMessage, androidMarketURL)
                    } else if (isMaintenanceAndroid) {
                        showAlertDialog(activity.getString(R.string.system), maintenanceMessage, AlertType.OnlyMessage)
                    } else if (androidOptionalVersion > versionCode) {
                        showAlertDialog(activity.getString(R.string.system), optionalMessage, AlertType.OptionalMessage, androidMarketURL)
                    } else {
                        success()
                    }
                }
            }
    }
    fun showAlertDialog(title: String, message: String, type: AlertType, marketUrl: String? = null) {
        MaterialDialog(activity.applicationContext).show {
            message(text = message)
            title(text = title)
            cancelable(false)
            if (type == AlertType.OnlyMessage) {
                cancelable(true)
                positiveButton(R.string.ok)
                onCancel {
                    dismiss()
                }
                positiveButton {
                    dismiss()
                }
            }
            if (type == AlertType.OptionalMessage) {
                positiveButton(R.string.update)
                positiveButton {
                    marketUrl?.let {
                        activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it)))
                    }
                }
                negativeButton(R.string.ok)
                negativeButton {
                    success()
                }
            }

            if (type == AlertType.ForceMessage) {
                positiveButton(R.string.update)
                positiveButton {
                    marketUrl?.let {
                        activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it)))
                    }
                }
            }
        }
    }
}
enum class AlertType() {
    OnlyMessage,
    OptionalMessage,
    ForceMessage
}
