package com.example.todo

import CustomAdapter
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataset = mutableListOf("Hi", "Hello")

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.adapter = CustomAdapter(dataset)
        recyclerView.setHasFixedSize(true)

        //binding.addItemButton.setOnClickListener { (recyclerView.adapter as CustomAdapter).addItem() }
    }

}