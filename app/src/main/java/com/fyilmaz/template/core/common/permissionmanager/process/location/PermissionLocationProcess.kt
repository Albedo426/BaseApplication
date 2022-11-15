package com.fyilmaz.template.core.common.permissionmanager.process.location

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationManager
import android.os.Looper
import android.provider.Settings
import androidx.activity.result.ActivityResult
import androidx.fragment.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog
import com.fyilmaz.template.R
import com.fyilmaz.template.core.common.permissionmanager.PermissionHandler
import com.fyilmaz.template.core.common.permissionmanager.PermissionHelper
import com.fyilmaz.template.core.common.permissionmanager.PermissionHelper.REQ_PERMISSION_LOCATION
import com.fyilmaz.template.core.common.permissionmanager.process.BasePermissionProcess
import com.fyilmaz.template.core.common.permissionmanager.process.IBaseProcess
import com.fyilmaz.template.core.common.permissionmanager.process.RequestCode
import com.fyilmaz.template.core.platform.BetterActivityResult
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import timber.log.Timber

class PermissionLocationProcess(val context: Context, val fragment: Fragment, private val baseProcess: IBaseProcess<Location>) : BasePermissionProcess(fragment) {
    private fun requestLocationPermissions() = PermissionHandler.requestPermission(
        fragment,
        REQ_PERMISSION_LOCATION,
        PermissionHelper.locationPermissions.toTypedArray()
    ) {
        if (checkLocationEnabled()) {
            startLocationUpdates()
        } else {
            buildAlertMessageNoGps()
        }
    }
    private fun locationRequestMessage() {
        MaterialDialog(context).show {
            message(R.string.permission_message)
            title(R.string.permission_title)
            negativeButton(R.string.cancel) {
                baseProcess.unsuccessfulPermission(requestCode = requestCode)
            }
            positiveButton(R.string.ok) {
                requestLocationPermissions()
            }
        }
    }
    fun permissionControl(requestCode: RequestCode) {
        this.requestCode = requestCode
        if (!PermissionHelper.checkLocationPermission(context)) {
            locationRequestMessage()
        } else {
            if (checkLocationEnabled()) {
                startLocationUpdates()
            } else {
                buildAlertMessageNoGps()
            }
        }
    }
    private fun buildAlertMessageNoGps() {
        MaterialDialog(context).show {
            message(R.string.location_permission_description)
            title(R.string.permission_title)
            negativeButton(R.string.cancel) {
                baseProcess.unsuccessfulPermission(requestCode = requestCode)
            }
            positiveButton(R.string.open_location) {
                activityLauncher.launch(
                    Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS),
                    object : BetterActivityResult.OnActivityResult<ActivityResult> {
                        override fun onActivityResult(result: ActivityResult) {
                            if (PermissionHandler.checkPermissions(
                                    fragment.requireActivity(),
                                    PermissionHelper.locationPermissions.toTypedArray()
                                )
                            ) {
                                startLocationUpdates()
                            } else {
                                requestLocationPermissions()
                            }
                        }
                    }
                )
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun startLocationUpdates() {
        try {
            // permission was allowed
            baseProcess.successPermission(requestCode = requestCode)
            val locationClient =
                LocationServices.getFusedLocationProviderClient(
                    context
                )
            val locationRequest = LocationRequest.create().apply {
                interval = 1000
                fastestInterval = 5000
                priority = LocationRequest.PRIORITY_LOW_POWER
            }
            locationClient.requestLocationUpdates(
                locationRequest,
                object : LocationCallback() {
                    override fun onLocationResult(locationResult: LocationResult) {
                        locationResult ?: return
                        locationResult.locations.forEach { location ->
                        }
                    }
                },
                Looper.getMainLooper()
            )
        } catch (ex: Exception) {
            Timber.tag("startLocationUpdates").e(ex)
        }
    }
    private fun checkLocationEnabled(): Boolean {
        val manager =
            context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return manager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }
}
