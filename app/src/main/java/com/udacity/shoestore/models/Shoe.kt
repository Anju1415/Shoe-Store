package com.udacity.shoestore.models

import android.os.Parcelable
import com.udacity.shoestore.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String="", var size: String="", var company: String="", var description: String=""):Parcelable
