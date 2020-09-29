package com.tamil.assignment.features.products.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.tamil.assignment.R
import com.tamil.assignment.data.repo.gifs.response.GifData
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_product.view.*


class ProductsListAdapter(
    var onItemSelected: (gifData: GifData) -> Unit
) :
    RecyclerView.Adapter<ProductsListAdapter.ProductListViewHolder>() {

    private val items: ArrayList<GifData> = arrayListOf()

    class ProductListViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        return ProductListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.loading_error)
            .error(R.drawable.loading_error)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)

        Glide.with(holder.containerView).asGif().load(items[position].image_original_url).apply(options)
            .into(holder.containerView.gif)
        holder.containerView.gif.setOnClickListener {
            onItemSelected(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateContent(gifItems: List<GifData>) {
        this.items.clear()
        this.items.addAll(gifItems)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.items.clear()
        notifyDataSetChanged()
    }
}