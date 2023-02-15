package com.nrp.shift_test_task.network

import com.nrp.shift_test_task.DTO.CardDTO
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://lookup.binlist.net/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CardApiService {
    @GET(basicCardNumber)
    suspend fun getInfo(): CardDTO
}

object CardApi {
    val retrofitService : CardApiService by lazy {
        retrofit.create(CardApiService::class.java)
    }
}