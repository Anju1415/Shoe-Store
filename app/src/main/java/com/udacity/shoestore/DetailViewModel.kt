package com.udacity.shoestore

import androidx.lifecycle.*
import com.udacity.shoestore.models.Shoe

class DetailViewModel(state : SavedStateHandle):ViewModel() {

    // Keep the key as a constant
    companion object {
        private val NAME = "shoeName"
        private val COMPANY="companyName"
        private val SIZE="shoeSize"
        private val DESCRIPTION="shoeDescription"
    }


    private val savedStateHandle = state

    private val _name :MutableLiveData<String> = savedStateHandle.getLiveData(NAME)
    val name: LiveData<String>
        get() = _name

    private val _company:MutableLiveData<String> =savedStateHandle.getLiveData(COMPANY)
    val company:LiveData<String>
    get()=_company


    private val _size:MutableLiveData<String> = savedStateHandle.getLiveData(SIZE)
    val size:LiveData<String>
        get()=_size

    private val _description: MutableLiveData<String> = savedStateHandle.getLiveData(DESCRIPTION)
    val description:LiveData<String>
        get()=_description


    private var _navigateToShoeCollection = MutableLiveData<Shoe>()
    val navigateToShoeCollection: LiveData<Shoe>
        get() = _navigateToShoeCollection

    fun doneNavigating(){
        _navigateToShoeCollection.value = null
    }

    fun saveCurrentDetail( detail:Shoe) {

        // Sets a new value for the object associated to the key.
        savedStateHandle.set(NAME,detail.name)
        savedStateHandle.set(COMPANY,detail.company)
        savedStateHandle.set(SIZE,detail.size)
        savedStateHandle.set(DESCRIPTION,detail.description)

        val shoe  = Shoe(NAME, SIZE, COMPANY, DESCRIPTION)
        _navigateToShoeCollection.value=shoe

    }


}