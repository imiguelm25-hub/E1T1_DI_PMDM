package com.example.e1t1_di.ekitaldiDatuak

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.util.Date

@Serializable
data class Ekitaldia(

    // documentName
    // documentDescription
    // eventType
    // eventStartDate
    // eventWhere
    // eventTimeTable
    // eventPrice String edo double?
    @SerialName("documentName") val name: String? = "",
    @SerialName("eventType") val mota: String? = "",
    @SerialName("eventStartDate") val data: String? = "",
    @SerialName("eventWhere") val lekua: String? = "",
    @SerialName("eventTimeTable") val ordua: String? = "",
    @SerialName("eventPrice") val prezioa: String? = null
    ){

}
