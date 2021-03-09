package ke.co.topup.retrofittrial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ke.co.topup.retrofittrial.databinding.ActivityMainBinding
import ke.co.topup.retrofittrial.repository.Repository
import ke.co.topup.retrofittrial.viewModel.MainViewModel
import ke.co.topup.retrofittrial.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->

            if(response.isSuccessful){
                Log.d("Response",""+ response.body()?.userId.toString())
                Log.d("Response", ""+ response.body()?.id.toString())
                //Log.d("Response", ""+ response.body()?.tittle!!)
                binding.textView.text = response.body()?.tittle!!
                Log.d("Response", ""+ response.body()?.body!!)
            }else{
                Log.d("Response",""+ response.errorBody().toString())
                //binding.textView = response.code().toString()
            }
        })
    }
}