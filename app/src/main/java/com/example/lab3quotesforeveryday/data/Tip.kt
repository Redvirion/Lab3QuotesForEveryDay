package com.example.lab3quotesforeveryday.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tip(
    val dayNumber: Int,
    val title: String,
    val shortDescription: String,
    val imageResId: Int,
    val fullDescription: String
) : Parcelable