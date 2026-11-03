package com.example.listhomework

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listhomework.adapter.NumberAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: NumberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val recyclerView = findViewById<RecyclerView>(
            R.id.recyclerView
        )

        val addButton = findViewById<Button>(
            R.id.addButton
        )

        adapter = NumberAdapter()

        val columns = resources.getInteger(
            R.integer.grid_columns
        )

        recyclerView.layoutManager = GridLayoutManager(
            this,
            columns
        )

        recyclerView.adapter = adapter

        val spacing = resources.getDimensionPixelSize(
            R.dimen.item_spacing
        )

        recyclerView.addItemDecoration(
            GridSpacingItemDecoration(spacing)
        )

        viewModel.items.observe(this) { items ->
            adapter.submitList(items)
        }

        addButton.setOnClickListener {
            viewModel.addItem()
        }
    }
}