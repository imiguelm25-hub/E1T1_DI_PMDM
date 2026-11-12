package com.example.e1t1_di.ekitaldiDatuak

import android.content.Context
import kotlin.collections.emptyList
import kotlinx.serialization.json.Json


class ekitaldiZerrenda {
    fun datuakKargatu(context : Context) : List<Ekitaldia>{
        return try {
            val jsonString = context.assets.open("kulturEkitaldiak.json").
                    bufferedReader().use { it.readText()}
            Json { ignoreUnknownKeys = true }
                .decodeFromString<List<Ekitaldia>>(jsonString)

        } catch (e: Exception){
            e.printStackTrace()
            emptyList()
        }
    }
}