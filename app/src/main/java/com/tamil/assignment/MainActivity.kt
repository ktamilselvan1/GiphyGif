package com.tamil.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.coroutineScope
import androidx.navigation.findNavController
import com.tamil.assignment.ext.performDelayedSearch
import com.tamil.assignment.features.products.ProductsListFragmentDirections
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}