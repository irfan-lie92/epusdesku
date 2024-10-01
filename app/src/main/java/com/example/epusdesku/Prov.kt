package com.example.epusdesku

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Perpus(
    val name: String,
    val desa: String,
    val tahun: Int,
    val description: String,
    val pemustaka: String,
    val photo: Int
) : Parcelable


