package com.example.gryus.footballclub

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListClub(val nama : String, val image : Int, val keterangan : String) : Parcelable