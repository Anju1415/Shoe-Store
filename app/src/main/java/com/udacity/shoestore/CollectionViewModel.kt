package com.udacity.shoestore

import android.app.Application
import androidx.lifecycle.*
import com.udacity.shoestore.models.Shoe

class CollectionViewModel(private var shoe : Shoe = Shoe(),val application: Application): ViewModel() {



    private val _shoes= MutableLiveData<MutableList<Shoe>>()
    val shoes : LiveData<MutableList<Shoe>>
        get() = _shoes

    private val list = mutableListOf<Shoe>()

    init {
        list.add(shoe)
        _shoes.value=list
    }
/*
        list.add(shoe!!)
        _shoes.value=list*/


        val shoesString = Transformations.map(_shoes) { _shoes ->
            formatShoeDetail(_shoes, application.resources)
        }


}