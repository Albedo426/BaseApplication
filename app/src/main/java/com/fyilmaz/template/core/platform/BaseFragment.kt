package com.fyilmaz.template.core.platform

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fyilmaz.template.R
import com.fyilmaz.template.core.extensions.observe
import com.fyilmaz.template.core.extensions.observeEvent
import com.fyilmaz.template.core.views.ProgressDialog
import com.fyilmaz.template.core.views.toasty.Toasty

abstract class BaseFragment<DB : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutId: Int,
    private val viewModelClass: Class<VM>
) : Fragment() {

    val viewModel by lazy {
        ViewModelProvider(this).get(viewModelClass)
    }
    lateinit var binding: DB

    lateinit var progressDialog: ProgressDialog
    abstract fun getScreenKey(): String
    abstract fun onDataBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressDialog = ProgressDialog(requireContext(), ProgressDialog.THEME_LIGHT)
        progressDialog.isCancelable = true
        binding.lifecycleOwner = viewLifecycleOwner
        onDataBinding()
        getScreenKey()
        observeEvent(viewModel.baseEvent, ::onViewEvent)

        observe(viewModel.loading) {
            if (it)
                showProgressView()
            else
                hideProgressView()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    private fun onViewEvent(event: BaseViewEvent) {
        when (event) {
            is BaseViewEvent.ShowCustomError -> showError(event.message)
        }
    }

    fun showError(message: String) {
        try {
            Toasty.error(requireContext(), message).show()
        } catch (e: IllegalStateException) {
        }
    }

    fun showSuccess(message: String) {
        try {
            Toasty.success(requireContext(), message).show()
        } catch (e: IllegalStateException) {
        }
    }

    fun doubleClickBlocked(view: View) {
        view.apply {
            isEnabled = false
            postDelayed({ isEnabled = true }, 400)
        }
    }

    internal fun hideSoftInput() {
        activity?.let {
            (it.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).apply {
                it.currentFocus
                hideSoftInputFromWindow(
                    (it.currentFocus ?: View(requireContext())).windowToken,
                    0
                )
            }
        }
    }

    internal fun showSoftInput() {
        val inputManager =
            requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
    }

    fun showProgressView() {
        progressDialog.show()
    }

    fun hideProgressView() {
        progressDialog.dismiss()
    }

    open fun finishApp() {
        requireActivity().finish()
        val finishIntent =
            Intent(Intent.ACTION_MAIN).apply {
                addCategory(Intent.CATEGORY_HOME)
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }

        startActivity(finishIntent)
    }
}
