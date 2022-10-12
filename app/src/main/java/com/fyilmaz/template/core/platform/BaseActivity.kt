package com.fyilmaz.template.core.platform

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.fyilmaz.template.R
import com.fyilmaz.template.core.extensions.observe
import com.fyilmaz.template.core.extensions.observeEvent
import com.fyilmaz.template.core.views.ProgressDialog
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseActivity<DB : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutId: Int,
    private val viewModelClass: Class<VM>
) : AppCompatActivity() {


    val binding by lazy {
        DataBindingUtil.setContentView(this, layoutId) as DB
    }
    val viewModel by lazy {
        ViewModelProvider(this).get(viewModelClass)
    }
    protected val activityLauncher: BetterActivityResult<Intent, ActivityResult> =
        BetterActivityResult.registerActivityForResult(this)

    lateinit var progressDialog: ProgressDialog
    abstract fun onDataBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        observeEvent(viewModel.baseEvent, ::onViewEvent)
        progressDialog = ProgressDialog(this, ProgressDialog.THEME_LIGHT)
        progressDialog.isCancelable=false
        onDataBinding()

        observe(viewModel.loading) {
            if (it)
                showProgressView()
            else
                hideProgressView()
        }
    }

    private fun onViewEvent(event: BaseViewEvent) {
        when (event) {
            is BaseViewEvent.ShowCustomError -> showError(event.message)
        }
    }

    fun showCommonError() {
        Toast.makeText(baseContext, getString(R.string.something_went_wrong), Toast.LENGTH_LONG).show()
    }

    fun showError(@StringRes error: Int) {
        Toast.makeText(baseContext, getString(error), Toast.LENGTH_LONG).show()
    }

    fun showError(error: String) {
        Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
    }
    fun showProgressView() {
        progressDialog.show()
    }

    fun hideProgressView() {
        progressDialog.dismiss()
    }

    open fun finishApp() {
        finish()
        val finishIntent =
            Intent(Intent.ACTION_MAIN).apply {
                addCategory(Intent.CATEGORY_HOME)
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }

        startActivity(finishIntent)
    }
}
