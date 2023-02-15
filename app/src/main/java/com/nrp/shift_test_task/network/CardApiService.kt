package com.nrp.shift_test_task.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://lookup.binlist.net/45717360"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DishApiService {
    @GET
    suspend fun getMenu():  List<Items>
}

object DishApi {
    val retrofitService : DishApiService by lazy {
        retrofit.create(DishApiService::class.java)
    }
}