package binar.academy.chapter6_topik4_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import binar.academy.chapter6_topik4_mvvm.model.ResponseDataCarItem
import binar.academy.chapter6_topik4_mvvm.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarViewModel : ViewModel() {

    private val liveDataCars : MutableLiveData<List<ResponseDataCarItem>> = MutableLiveData()

    fun getLiveDataCars() : MutableLiveData<List<ResponseDataCarItem>> = liveDataCars

    fun showAllDataCars(){
        ApiService.instance.getAllDataCar()
            .enqueue(object : Callback<List<ResponseDataCarItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataCarItem>>,
                    response: Response<List<ResponseDataCarItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataCars.postValue(response.body())
                    }else{
                        liveDataCars.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataCarItem>>, t: Throwable) {
                    liveDataCars.postValue(null)
                }

            })
    }
}