package app.posts.johnny.abanoub.mvvm_posts

import app.posts.johnny.abanoub.mvvm_posts.network.Scheduler
import io.reactivex.schedulers.Schedulers

class ScheduleProvider: Scheduler {
    override fun IO(): io.reactivex.Scheduler? {
        return Schedulers.trampoline()
    }

    override fun mainThread(): io.reactivex.Scheduler? {
        return Schedulers.trampoline()
    }

}