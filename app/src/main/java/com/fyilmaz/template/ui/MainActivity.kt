package com.fyilmaz.template.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.fyilmaz.template.R
import com.fyilmaz.template.core.platform.BaseActivity
import com.fyilmaz.template.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :
    BaseActivity<ActivityMainBinding, MainViewModel>(
    layoutId = R.layout.activity_main,
    viewModelClass = MainViewModel::class.java
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onDataBinding() {
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java).apply {
            }
        }
    }
}
