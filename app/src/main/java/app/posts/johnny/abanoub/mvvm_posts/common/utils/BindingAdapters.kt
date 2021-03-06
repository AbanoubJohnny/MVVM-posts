package app.posts.johnny.abanoub.mvvm_posts.common.utils

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.support.v7.app.AppCompatActivity
import android.view.View
import app.posts.johnny.abanoub.mvvm_posts.common.utils.extension.getParentActivity

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
        val parentActivity: AppCompatActivity? = view.getParentActivity()
        if(parentActivity != null && visibility != null) {
            visibility.observe(parentActivity, Observer { value -> view.visibility = value?:View.VISIBLE })
        }
}
