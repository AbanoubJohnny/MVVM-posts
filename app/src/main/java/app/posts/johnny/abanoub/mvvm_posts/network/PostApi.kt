package app.posts.johnny.abanoub.mvvm_posts.network

import app.posts.johnny.abanoub.mvvm_posts.common.utils.extension.POSTS
import app.posts.johnny.abanoub.mvvm_posts.model.Post
import io.reactivex.Single
import retrofit2.http.GET

interface PostApi {
    /**
     * Get the list of the pots from the API
     */
    @GET(POSTS)
    fun getPosts(): Single<List<Post>>

}