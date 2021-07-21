package com.joelson.task7api.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.joelson.task7api.adapter.StudentAdapter
import com.joelson.task7api.databinding.ActivityStudentsBinding
import com.joelson.task7api.model.StudentModel
import com.joelson.task7api.viewModel.StudentViewModel

class StudentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentsBinding
    private lateinit var myStudentAdapter: StudentAdapter
    private lateinit var sviewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myStudentAdapter = StudentAdapter(listOf())
        binding.recyclerStudent.adapter = myStudentAdapter

        sviewModel = ViewModelProvider(this)[StudentViewModel::class.java]


        binding.submitStudent.setOnClickListener {
            addNewStudent()
        }

    }

    fun addNewStudent() {
        binding.submitStudent.setOnClickListener {
            var name: String = binding.saveName.text.toString()
            var seat: Int = binding.saveSeat.text.toString().toInt()
            var studentClass: String = binding.saveClass.text.toString()

            if (name.isNotEmpty() && studentClass.isNotEmpty() && seat !=null) {

                var myPost = StudentModel(studentClass, name, seat)
                sviewModel.apply {
                    sviewModel.pushPost(myPost)

                }

                Toast.makeText(this, "Saved Successfully", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG)
                    .show()
            }
        }


    }
}


