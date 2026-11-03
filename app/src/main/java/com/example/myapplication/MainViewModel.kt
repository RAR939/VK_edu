package com.example.listhomework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _items = MutableLiveData<List<Int>>(emptyList())

    val items: LiveData<List<Int>> = _items

    fun addItem() {
        val currentItems = _items.value.orEmpty()

        _items.value = currentItems + currentItems.size
    }
}