package ke.co.topup.retrofittrial.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ke.co.topup.retrofittrial.model.Post
import ke.co.topup.retrofittrial.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response : Response<Post> =repository.getPost()
                myResponse.value = response
        }
    }
}