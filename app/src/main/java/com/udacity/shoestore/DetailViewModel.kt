package com.udacity.shoestore

import android.app.Activity
import android.app.Application
import androidx.lifecycle.*
import com.udacity.shoestore.models.Shoe

class DetailViewModel(application: Application): ViewModel() {

    private var _navigateToShoeCollection = MutableLiveData<Boolean>()
    val navigateToShoeCollection: LiveData<Boolean>
        get() = _navigateToShoeCollection

    fun navigateToShoeCollections(){
        _navigateToShoeCollection.value = false
    }

    private val _shoes= MutableLiveData<MutableList<Shoe>>()
    private val shoes : LiveData<MutableList<Shoe>>
        get() = _shoes

/*
    private val list :MutableList<Shoe> = mutableListOf()
    init {
        _shoes.value=list
    }
*/


     fun saveCurrentDetail(detail:Shoe?) {
        // Sets a new value for the object associated to the key.
       /* savedStateHandle.set(NAME,detail.name)
        savedStateHandle.set(COMPANY,detail.company)
        savedStateHandle.set(SIZE,detail.size)
        savedStateHandle.set(DESCRIPTION,detail.description)
*/
        //val shoe  = Shoe(detail.name, detail.size, detail.company, detail.description)
      //  list.add(detail)

         _shoes.value?.add(detail!!)
        _navigateToShoeCollection.value=true

    }

    val shoesString = Transformations.map(shoes) { shoes ->
        formatShoeDetail(shoes, application.resources)
    }


}