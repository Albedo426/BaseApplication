package com.fyilmaz.template.ui.prelogin.splash.presenter

import android.os.CountDownTimer
import android.util.Log
import com.fyilmaz.template.R
import com.fyilmaz.template.core.common.PageName.Login.splash
import com.fyilmaz.template.core.common.TimerType
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
    lateinit var timer: CountDownTimer
    override fun getScreenKey(): String {
        return splash
    }

    override fun onDataBinding() {
        viewModel.runTimer(
            {
                Log.e("TAG", "onFinish: a")
            },
            {
                Log.e("TAG", "onTick: a")
            },
            20000,1000,
            true,
            TimerType.OneTimeTimer,
        )
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
