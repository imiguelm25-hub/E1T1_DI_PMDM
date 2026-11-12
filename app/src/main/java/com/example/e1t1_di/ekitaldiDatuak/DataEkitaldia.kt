package com.example.e1t1_di.ekitaldiDatuak

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataEkitaldia(
    @SerialName("\$date")
    val data: String = "")
