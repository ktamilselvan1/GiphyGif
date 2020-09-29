package com.tamil.assignment.features.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.tamil.assignment.MainActivity
import com.tamil.assignment.R
import com.tamil.assignment.base.BaseFragment
import com.tamil.assignment.data.base.Status
import com.tamil.assignment.data.repo.gifs.response.GifData
import com.tamil.assignment.databinding.FragmentGifDetailBinding
import com.tamil.assignment.features.products.viewmodel.ProductsViewModel
import kotlinx.android.synthetic.main.header.view.*

class ProductDetailFragment : BaseFragment() {

    private val viewModel by viewModels<ProductsViewModel> { viewModelFactory }

    private lateinit var binding: FragmentGifDetailBinding

    private val args: ProductDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGifDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (args.gifDetail != null) {
            setupGif(args.gifDetail)
            binding.detailSearchLayout.visibility = View.GONE
            binding.toolbarLayout.back.visibility = View.VISIBLE
        } else {
            binding.detailSearchLayout.visibility = View.VISIBLE
            binding.toolbarLayout.back.visibility = View.GONE
            viewModel.getRandomGif().observe(viewLifecycleOwner, Observer {
                it?.let {
                    when (it.status) {
                        Status.ERROR -> {

                        }
                        Status.SUCCESS -> {
                            it.data?.let { gifResponse ->
                                setupGif(gifResponse.data)
                            }

                        }
                        else -> {

                        }
                    }
                }
            })
        }
        binding.toolbarLayout.back.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.detailSearchLayout.setOnClickListener {
            val action = ProductDetailFragmentDirections.navigateToSearch()
            findNavController().navigate(action)
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
    }

    private fun setupGif(gifDetail: GifData?) {
        gifDetail?.let {
            binding.loadingProgress.visibility = View.VISIBLE

            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .error(R.drawable.loading_error)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)

            Glide.with(this).asGif().load(gifDetail.image_original_url).apply(options).into(binding.gifImage)
            binding.title.text = it.title
            binding.link.text = it.image_original_url
            binding.pg.text = it.rating?.toUpperCase()
        }
        if (args.gifDetail != null) {
            binding.header.text = ""
            if (requireActivity() is MainActivity) {
                args.gifDetail!!.title?.let { binding.toolbarLayout.toolbarTitle.text = it }
            }
        } else {
            binding.header.text = getString(R.string.random_gif)
            if (requireActivity() is MainActivity) {
                binding.toolbarLayout.toolbarTitle.text = getString(R.string.app_name)
            }
        }
    }
}