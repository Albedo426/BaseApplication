package com.fyilmaz.template.ui.auth.login.presenter

import android.os.Bundle
import com.fyilmaz.template.R
import com.fyilmaz.template.core.common.PageName.Login.login
import com.fyilmaz.template.core.common.permissionmanager.process.location.PermissionLocationProcess
import com.fyilmaz.template.core.extensions.observeEvent
import com.fyilmaz.template.core.platform.BaseFragment
import com.fyilmaz.template.core.platform.GlobalApplication
import com.fyilmaz.template.databinding.FragmentLoginBinding
import com.fyilmaz.template.ui.MainActivity
import com.fyilmaz.template.ui.auth.login.domain.LoginViewEvent
import com.fyilmaz.template.ui.auth.login.domain.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(
    layoutId = R.layout.fragment_login,
    viewModelClass = LoginViewModel::class.java
) {
    override fun getScreenKey(): String {
        return login
    }

    override fun onDataBinding() {
        binding.viewModel = viewModel
        observeEvent(viewModel.event, ::onViewEvent)
        val plp = PermissionLocationProcess(context = context!!, fragment = this)
        plp.permissionControl()
    }

    private fun onViewEvent(event: LoginViewEvent) {
        when (event) {
            is LoginViewEvent.GoToMain -> {
                GlobalApplication.preferenceManager.token = event.item.token
                GlobalApplication.preferenceManager.isLogin = true
                startActivity(MainActivity.newIntent(requireContext())).apply {
                    requireActivity().finish()
                }
            }
        }
    }
    companion object {
        fun newInstance(args: Bundle? = null): LoginFragment {
            val fragment = LoginFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
