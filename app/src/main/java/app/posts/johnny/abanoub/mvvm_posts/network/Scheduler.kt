package app.posts.johnny.abanoub.mvvm_posts.network

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface Scheduler {

    fun IO(): Scheduler?
    fun mainThread(): Scheduler?
}