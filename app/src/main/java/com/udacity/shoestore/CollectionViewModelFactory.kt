package com.udacity.shoestore

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.models.Shoe
import java.lang.Appendable

class CollectionViewModelFactory(
    private val shoe: Shoe,private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CollectionViewModel::class.java)) {
            return CollectionViewModel(shoe,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}