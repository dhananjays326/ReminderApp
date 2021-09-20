package com.d.reminderapp

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d.reminderapp.network.ApiCall
import com.d.reminderapp.network.ApiResponse
import com.d.reminderapp.network.Schedule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(private val api : ApiCall) : ViewModel() {

    private val _uiState = MutableLiveData<UpdateUiStatement>()
    val uiState : LiveData<UpdateUiStatement> = _uiState

    fun getApiResponse(){

        viewModelScope.launch {
            withContext(Dispatchers.IO){
              val response = api.getResponse()

                if(response!=null){
                    response.let {
                        _uiState.postValue(UpdateUiStatement.Content(listOfData = it.scheduleList))
                    }
                }else{

                    _uiState.postValue(UpdateUiStatement.Error(message = "Please check internet"))
                }
            }
        }
    }
}

sealed class UpdateUiStatement{

    data class Content(val listOfData: List<Schedule>) : UpdateUiStatement()
    data class Error(val message : String) : UpdateUiStatement()


}