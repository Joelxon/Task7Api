package com.joelson.task7api.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.joelson.task7api.adapter.ItemAdapter
import com.joelson.task7api.databinding.ActivityMainBinding
import com.joelson.task7api.viewModel.ItemViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myItemAdapter: ItemAdapter
    private lateinit var viewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        myItemAdapter = ItemAdapter(listOf())
        binding.recyclerMain.adapter = myItemAdapter

        viewModel = ViewModelProvider(this)[ItemViewModel::class.java]

        viewModel.apply {
            getAllItems()
            items.observe(this@MainActivity, {item ->
                myItemAdapter.items = item
                myItemAdapter.notifyDataSetChanged()
            })
        }

        binding.button.setOnClickListener {
            val intent: Intent = Intent(this, StudentsActivity::class.java)
            startActivity(intent)
        }

    }
}
