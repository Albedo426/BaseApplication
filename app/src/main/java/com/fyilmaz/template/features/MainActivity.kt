package com.fyilmaz.template.features

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.fyilmaz.template.R
import com.fyilmaz.template.core.base.BaseActivity
import com.fyilmaz.template.databinding.ActivityMainBinding
import com.fyilmaz.template.features.main.domain.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :
    BaseActivity<ActivityMainBinding, MainViewModel>(
        layoutId = R.layout.activity_main,
        viewModelClass = MainViewModel::class.java
    ) {
    @NavigationRes
    private val navigationGraph: Int =
        R.navigation.navigate
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onInitDataBinding() {
        setNavigation()
    }
    private fun setNavigation() {
        val host = NavHostFragment.create(navigationGraph)
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.frameLayout,
                host,
                host.tag
            )
            .setPrimaryNavigationFragment(host)
            .runOnCommit {
                this.navController = host.navController
            }.commit()
    }

    companion object {
        fun gotoMainActivity(context: Context) = Intent(context, MainActivity::class.java)
    }
}
