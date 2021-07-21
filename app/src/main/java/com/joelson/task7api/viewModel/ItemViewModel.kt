package com.joelson.task7api.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joelson.task7api.apiService.RetrofitProvider
import com.joelson.task7api.model.ItemModel
import com.joelson.task7api.model.StudentModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel: ViewModel() {

    val items: MutableLiveData<List<ItemModel>> = MutableLiveData()

    fun getAllItems(){
        CoroutineScope(Dispatchers.IO).launch {
            val item: List<ItemModel> = RetrofitProvider.service.getAllItems()
            items.postValue(item)
        }
    }
}