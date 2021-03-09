package ke.co.topup.retrofittrial.api

import ke.co.topup.retrofittrial.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost(): Response<Post>
}