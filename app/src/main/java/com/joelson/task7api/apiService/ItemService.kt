package com.joelson.task7api.apiService

import com.joelson.task7api.model.ItemModel
import retrofit2.http.GET

interface ItemService {
    @GET("items")
    suspend fun getAllItems(): List<ItemModel>
}