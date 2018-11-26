package app.posts.johnny.abanoub.mvvm_posts.network.injection

import app.posts.johnny.abanoub.mvvm_posts.common.bases.BaseViewModel
import app.posts.johnny.abanoub.mvvm_posts.network.injection.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(baseViewModel: BaseViewModel)
    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}