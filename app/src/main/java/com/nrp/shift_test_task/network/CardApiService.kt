package com.nrp.shift_test_task.network

import androidx.lifecycle.LiveData
import com.nrp.shift_test_task.dto.CardDto
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
    val name: LiveData<Int>
    @GET()
    suspend fun getInfo(name: LiveData<Int>): CardDto
}

object CardApi {
    val retrofitService : CardApiService by lazy {
        retrofit.create(CardApiService::class.java)
    }
}