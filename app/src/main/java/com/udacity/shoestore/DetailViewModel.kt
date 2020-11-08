package com.udacity.shoestore

import androidx.lifecycle.*
import com.udacity.shoestore.models.Shoe

class DetailViewModel: ViewModel() {

    private val _shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    fun saveCurrentDetail(detail: Shoe?) {
        detail?.let {
            _shoes.value?.add(it)
        }
    }


}