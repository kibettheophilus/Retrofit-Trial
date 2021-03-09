package ke.co.topup.retrofittrial.repository

import ke.co.topup.retrofittrial.api.RetrofitInstance
import ke.co.topup.retrofittrial.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return  RetrofitInstance.api.getPost()
    }
}