package app.posts.johnny.abanoub.mvvm_posts.modules.posts

import android.arch.lifecycle.MutableLiveData
import app.posts.johnny.abanoub.mvvm_posts.model.Post

class PostViewModel {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post) {
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle(): MutableLiveData<String> {
        return postTitle
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }
}