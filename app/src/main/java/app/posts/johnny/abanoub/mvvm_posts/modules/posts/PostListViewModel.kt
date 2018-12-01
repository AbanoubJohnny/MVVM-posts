package app.posts.johnny.abanoub.mvvm_posts.modules.posts


import app.posts.johnny.abanoub.mvvm_posts.R
import app.posts.johnny.abanoub.mvvm_posts.common.bases.BaseViewModel
import app.posts.johnny.abanoub.mvvm_posts.model.Post
import app.posts.johnny.abanoub.mvvm_posts.network.PostApi
import javax.inject.Inject

class PostListViewModel : BaseViewModel() {
    @Inject
    lateinit var postApi: PostApi

    val postListAdapter: PostListAdapter = PostListAdapter()

    init {
        loadPosts()
    }

    private fun loadPosts() {
        addDisposable(postApi.getPosts()
            .subscribeOn(scheduleProvider.IO())
            .observeOn(scheduleProvider.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doAfterTerminate { onRetrievePostListFinish() }
            .subscribe { t1, t2 -> onRetrievePostListSuccess(t1); onRetrievePostListError(t2) }
        )
    }

    private fun onRetrievePostListSuccess(posts: List<Post>) {
        postListAdapter.updatePostList(posts)
    }

    private fun onRetrievePostListError(throwable: Throwable) {
        showError(R.string.post_error)
    }
}