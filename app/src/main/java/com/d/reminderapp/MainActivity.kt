package com.d.reminderapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.d.reminderapp.network.ApiCall
import com.d.reminderapp.network.ApiResponse
import com.d.reminderapp.network.Schedule
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainActivity : AppCompatActivity(),KoinComponent {

    lateinit var context: Context
    private val viewModel : MainActivityViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@MainActivity
        setUpObservers()
    }


    private  fun setUpObservers(){

         viewModel.getApiResponse()

        viewModel.uiState.observe(this){ state ->
            when(state){
               is UpdateUiStatement.Content -> renderResponse(state.listOfData)
                is UpdateUiStatement.Error -> renderError(state.message)
            }
        }
    }

    private fun renderResponse(response: List<Schedule>){

        Toast.makeText(applicationContext, response[0].scheduleCd,Toast.LENGTH_LONG).show()

    }
    private fun renderError(error : String){

    }
}