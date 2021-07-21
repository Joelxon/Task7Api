package com.joelson.task7api.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.joelson.task7api.R
import com.joelson.task7api.StudentAdapter
import com.joelson.task7api.databinding.ActivityStudentsBinding
import com.joelson.task7api.model.StudentModel
import com.joelson.task7api.viewModel.MainViewModel

class StudentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentsBinding
    private lateinit var myStudentAdapter: StudentAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myStudentAdapter = StudentAdapter(listOf())
        binding.recyclerStudent.adapter = myStudentAdapter

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]


        binding.submitStudent.setOnClickListener {
            addNewStudent()
        }

    }

    fun addNewStudent() {
        binding.submitStudent.setOnClickListener {
            var name: String = binding.saveName.text.toString()
            var seat: Int = binding.saveSeat.text.toString().toInt()
            var studentClass: String = binding.saveClass.text.toString()

            if (name.isNotEmpty() && studentClass.isNotEmpty()) {

                var myPost = StudentModel(studentClass, name, seat)
                viewModel.apply {
                    viewModel.pushPost(myPost)

                }

                Toast.makeText(this, "Saved Successfully", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Please fill out the required fields", Toast.LENGTH_LONG)
                    .show()
            }
        }


    }
}


