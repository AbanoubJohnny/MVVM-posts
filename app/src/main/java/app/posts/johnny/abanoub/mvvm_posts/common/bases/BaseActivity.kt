package app.posts.johnny.abanoub.mvvm_posts.common.bases

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import app.posts.johnny.abanoub.mvvm_posts.R

abstract class BaseActivity<VM:BaseViewModel, DB : ViewDataBinding>: AppCompatActivity(){
    private var errorSandbar: Snackbar? = null

    protected lateinit var viewModel: VM

    protected lateinit var binding: DB

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding= DataBindingUtil.setContentView(this,initiateReferencedLayout())
        viewModel = initiateViewModel()
    }

    abstract fun initiateReferencedLayout(): Int

    abstract fun initiateViewModel(): VM

    fun showError(@StringRes errorMessage: Int){
        errorSandbar = Snackbar.make(binding.root,errorMessage,Snackbar.LENGTH_INDEFINITE)
        errorSandbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSandbar?.show()
    }

    private fun hideError(){
        errorSandbar?.dismiss()
    }
}