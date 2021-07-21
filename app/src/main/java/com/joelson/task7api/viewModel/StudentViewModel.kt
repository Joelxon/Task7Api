package com.joelson.task7api.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joelson.task7api.apiService.RetrofitProvider
import com.joelson.task7api.model.ItemModel
import com.joelson.task7api.model.StudentModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel: ViewModel() {

    val students: MutableLiveData<List<StudentModel>> = MutableLiveData()
    val addStudent: MutableLiveData<List<StudentModel>> = MutableLiveData()


    fun pushPost(student: StudentModel){
        CoroutineScope(Dispatchers.IO).launch {
            val newStudent: List<StudentModel> = RetrofitProvider.service2.addStudent(student)
            addStudent.value = newStudent
        }
    }


    fun getAllStudents(){
        CoroutineScope(Dispatchers.IO).launch {
            val student: List<StudentModel> = RetrofitProvider.service2.getAllStudents()
            students.postValue(student)
        }
    }

}