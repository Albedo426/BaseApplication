package com.fyilmaz.template.ui.prelogin

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.fyilmaz.template.R
import com.fyilmaz.template.core.platform.BaseActivity
import com.fyilmaz.template.databinding.ActivityPreLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PreLoginActivity :
    BaseActivity<ActivityPreLoginBinding, PreLoginViewModel>(
        layoutId = R.layout.activity_pre_login,
        viewModelClass = PreLoginViewModel::class.java
    ) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDataBinding() {
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, PreLoginActivity::class.java).apply {
            }
        }
    }
}
