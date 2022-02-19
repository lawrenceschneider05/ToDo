package com.example.todo

import CustomAdapter
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var recyclerView: RecyclerView
    lateinit var addButtonView: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataset = mutableListOf("Take out trash", "Clean room", "Finish homework")

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        addButtonView = findViewById<Button>(R.id.add_button)

        recyclerView.adapter = CustomAdapter(dataset)
        recyclerView.setHasFixedSize(true)

        addButtonView.setOnClickListener {
            (recyclerView.adapter as CustomAdapter).addItem()
        }
    }

}