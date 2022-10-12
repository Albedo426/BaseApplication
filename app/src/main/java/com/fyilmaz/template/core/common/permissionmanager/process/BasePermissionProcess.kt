package com.fyilmaz.template.core.common.permissionmanager.process

import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.fragment.app.Fragment
import com.fyilmaz.template.core.platform.BetterActivityResult

abstract class BasePermissionProcess(fragment: Fragment) {
    protected val activityLauncher: BetterActivityResult<Intent, ActivityResult> =
        BetterActivityResult.registerActivityForResult(fragment)

}