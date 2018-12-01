package app.posts.johnny.abanoub.mvvm_posts.modules.posts

import android.os.Bundle
import android.os.PersistableBundle
import app.posts.johnny.abanoub.mvvm_posts.R
import app.posts.johnny.abanoub.mvvm_posts.common.bases.BaseActivity
import app.posts.johnny.abanoub.mvvm_posts.databinding.ActivityPostListBinding


class PostListActivity : BaseActivity<PostListViewModel, ActivityPostListBinding>() {
    override fun initiateReferencedLayout(): Int {
        return R.layout.activity_post_list
    }

    override fun initiateViewModel(): PostListViewModel {
        return ViewModelProviders.of(this).get(PostListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding.viewModel = viewModel
    }
}