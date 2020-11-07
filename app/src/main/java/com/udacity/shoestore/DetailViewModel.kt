package com.udacity.shoestore


import android.app.Application
import androidx.lifecycle.*
import com.udacity.shoestore.models.Shoe

class DetailViewModel(application: Application): ViewModel() {

    private val _shoes= MutableLiveData<List<Shoe>>()
    private val shoes : LiveData<List<Shoe>>
        get() = _shoes

    private val list = mutableListOf<Shoe>()
     fun saveCurrentDetail(detail:Shoe?) {
         list.add(detail!!)
         _shoes.value=list
    }

    var shoesString = Transformations.map(shoes) { shoes ->
        formatShoeDetail(shoes, application.resources)
    }


}