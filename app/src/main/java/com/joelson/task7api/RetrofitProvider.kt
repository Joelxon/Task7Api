package com.joelson.task7api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://ict-yep-backend.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: ItemService = retrofit.create(ItemService::class.java)
    val service2: StudentService = retrofit.create(StudentService::class.java)
}