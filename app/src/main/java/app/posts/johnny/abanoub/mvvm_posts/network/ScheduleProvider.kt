package app.posts.johnny.abanoub.mvvm_posts.network

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ScheduleProvider: Scheduler {
    override fun IO(): io.reactivex.Scheduler? {
        return Schedulers.io()
    }

    override fun mainThread(): io.reactivex.Scheduler? {
        return AndroidSchedulers.mainThread()
    }

}