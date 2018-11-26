package app.posts.johnny.abanoub.mvvm_posts.common.bases

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.annotation.CallSuper
import android.support.annotation.StringRes
import android.view.View
import app.posts.johnny.abanoub.mvvm_posts.modules.posts.PostListViewModel
import app.posts.johnny.abanoub.mvvm_posts.network.ScheduleProvider
import app.posts.johnny.abanoub.mvvm_posts.network.injection.DaggerViewModelInjector
import app.posts.johnny.abanoub.mvvm_posts.network.injection.module.NetworkModule
import app.posts.johnny.abanoub.mvvm_posts.network.injection.ViewModelInjector
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {
    //implement here base view method injection and methods

    private val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    private val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener {
        //TODO: implement here what you want to do on clicking retry
    }
    private val disposables: CompositeDisposable

    @Inject
    lateinit var scheduleProvider: ScheduleProvider

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
        disposables = CompositeDisposable()
    }

    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }

    fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun removeDisposal(disposable: Disposable) {
        disposables.remove(disposable)
    }

    @CallSuper
    override fun onCleared() {
        disposables.clear()
        errorMessage.value = null
        super.onCleared()
    }

    fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
    }

    fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    fun showError(@StringRes errorMessage: Int){
        this.errorMessage.value = errorMessage
    }
}