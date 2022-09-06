package com.fyilmaz.template.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.fyilmaz.template.R
import com.fyilmaz.template.core.platform.BaseActivity
import com.fyilmaz.template.databinding.ActivityAuthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseActivity<ActivityAuthBinding, AuthViewModel>(
    layoutId = R.layout.activity_auth,
    viewModelClass = AuthViewModel::class.java
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDataBinding() {
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, AuthActivity::class.java).apply {
            }
        }
    }
}
