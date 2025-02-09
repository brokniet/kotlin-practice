package com.example.firstkotlinpractice.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstkotlinpractice.data.models.Image
import com.example.firstkotlinpractice.databinding.ItemRvImageBinding

class ImageAdapter(
    private val images: MutableList<Image>
): RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(private val binding: ItemRvImageBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(image: Image) {
            Glide.with(binding.root.context)
                .load(image.url)
                .into(binding.ivImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemRvImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position])
    }
}