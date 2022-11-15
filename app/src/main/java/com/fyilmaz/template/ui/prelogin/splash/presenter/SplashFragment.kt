package com.fyilmaz.template.ui.prelogin.splash.presenter

import com.fyilmaz.template.R
import com.fyilmaz.template.core.common.PageName.Login.splash
import com.fyilmaz.template.core.common.firebse.RemoteConfig
import com.fyilmaz.template.core.platform.BaseFragment
import com.fyilmaz.template.core.platform.GlobalApplication
import com.fyilmaz.template.databinding.FragmentSplashBinding
import com.fyilmaz.template.ui.MainActivity
import com.fyilmaz.template.ui.auth.AuthActivity
import com.fyilmaz.template.ui.prelogin.splash.domain.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>(
    layoutId = R.layout.fragment_splash,
    viewModelClass = SplashViewModel::class.java
) {
    override fun getScreenKey(): String {
        return splash
    }

    override fun onDataBinding() {
        route()
    }
    fun route() {
        val login = GlobalApplication.preferenceManager.isLogin
        login?.let {
            if (it) {
                startActivity(MainActivity.newIntent(requireContext())).apply {
                    requireActivity().finish()
                }
            } else {
                startActivity(AuthActivity.newIntent(requireContext())).apply {
                    requireActivity().finish()
                }
            }
        } ?: run {
            startActivity(AuthActivity.newIntent(requireContext())).apply {
                requireActivity().finish()
            }
        }
    }
}
