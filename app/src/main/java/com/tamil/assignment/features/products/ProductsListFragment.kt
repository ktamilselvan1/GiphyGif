package com.tamil.assignment.features.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.coroutineScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tamil.assignment.base.BaseFragment
import com.tamil.assignment.data.base.Status
import com.tamil.assignment.databinding.FragmentGifListBinding
import com.tamil.assignment.ext.performDelayedSearch
import com.tamil.assignment.features.products.adapter.ProductsListAdapter
import com.tamil.assignment.features.products.viewmodel.ProductsViewModel
import kotlinx.android.synthetic.main.header.view.*
import kotlinx.android.synthetic.main.search_layout.*
import kotlinx.android.synthetic.main.search_layout.view.*
import kotlinx.coroutines.flow.collect

class ProductsListFragment : BaseFragment() {

    private lateinit var binding: FragmentGifListBinding

    private val viewModel by viewModels<ProductsViewModel> { viewModelFactory }

    private val adapter: ProductsListAdapter =
        ProductsListAdapter { gifData ->
            val action =
                ProductsListFragmentDirections.navigateToDetail(gifData)
            findNavController().navigate(action)
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGifListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.listToolbarLayout.back.visibility = View.VISIBLE
        binding.listSearchLayout.search.requestFocus()
        binding.listToolbarLayout.back.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.productsList.layoutManager =
            GridLayoutManager(requireContext(), 3)
        binding.productsList.adapter = adapter

        lifecycle.coroutineScope.launchWhenCreated {
            binding.listSearchLayout.search.performDelayedSearch().collect {
                if (it.isNotEmpty()) {
                    binding.listSearchLayout.cancel.visibility = View.VISIBLE
                    adapter.clearItems()
                    searchForGif(it)
                } else {
                    binding.listSearchLayout.cancel.visibility = View.GONE
                }
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            it?.let { showLoading ->
                if (showLoading) {
                    binding.progress.visibility = View.VISIBLE
                } else {
                    binding.progress.visibility = View.GONE
                }
            }
        })

        binding.listSearchLayout.clear.setOnClickListener {
            resetAndNavigateUp()
        }

        binding.listToolbarLayout.back.setOnClickListener {
            findNavController(this).popBackStack()
        }
        binding.listSearchLayout.cancel.setOnClickListener {
            resetAndNavigateUp()
        }

    }

    private fun searchForGif(it: String) {
        viewModel.searchGif(it).observe(viewLifecycleOwner, Observer {
            it?.let {
                when (it.status) {
                    Status.ERROR -> {
                        binding.progress.visibility = View.GONE
                    }
                    Status.SUCCESS -> {
                        binding.progress.visibility = View.GONE
                        it.data?.let { searchResponse ->
                            if (searchResponse.data != null) {
                                adapter.updateContent(searchResponse.data)
                            }
                        }
                    }
                    Status.LOADING -> {
                        binding.progress.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun resetAndNavigateUp() {
        binding.listSearchLayout.search.setText("")
        binding.listSearchLayout.search.clearFocus()
        findNavController().popBackStack()
    }
}