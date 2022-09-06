package com.fyilmaz.template.ui.prelogin.splash.presenter

import com.fyilmaz.template.R
import com.fyilmaz.template.core.platform.BaseFragment
import com.fyilmaz.template.databinding.FragmentSplashBinding
import com.fyilmaz.template.ui.auth.AuthActivity
import com.fyilmaz.template.ui.prelogin.splash.domain.SplashViewModel

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>(
    layoutId = R.layout.fragment_splash,
    viewModelClass = SplashViewModel::class.java
) {
    override fun getScreenKey(): String {
        return "SplashFragmentSplashFragment"
    }

    override fun onDataBinding() {
        /*startActivity(MainActivity.newIntent(requireContext())).apply {
            requireActivity().finish()
        }*/
        startActivity(AuthActivity.newIntent(requireContext())).apply {
            requireActivity().finish()
        }
    }
}