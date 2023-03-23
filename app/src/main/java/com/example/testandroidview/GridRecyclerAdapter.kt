package com.example.testandroidview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroidview.databinding.LayoutGridItemBinding

class GridRecyclerAdapter : RecyclerView.Adapter<GridRecyclerAdapter.Item>() {

    private val items = listOf(
        "apple",
        "banana",
        "grape",
        "syrup",
        "watermelon",
        "broccoli",
        "spinach",
        "cucumber",
        "9",
        "10"
    )

    data class Item(val binding: LayoutGridItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(stt: String, item: String) {
            binding.tvStt.text = stt
            binding.tvLabel.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Item {
        val binding = LayoutGridItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        // Set lại width item sao cho = 1 nửa chiều rộng màn hình
        val params = binding.root.layoutParams
        params.width = getScreenWidth(parent.context) / 2
        binding.root.layoutParams = params

        return Item(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: Item, position: Int) {
        holder.bind(position.toString(), items[position])
    }
}

private fun getScreenWidth(context: Context): Int {
    return context.resources.displayMetrics.widthPixels
}