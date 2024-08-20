package com.example.kotlinstudy.other

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.data.db.entities.ShoppingItem
import com.example.kotlinstudy.databinding.ShoppingItemBinding
import com.example.kotlinstudy.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(val binding: ShoppingItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        return ShoppingViewHolder(ShoppingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val item = items[position]

        holder.binding.tvName.text = item.name
        holder.binding.tvAmount.text = "${item.mount}"

        holder.binding.ivDelete.setOnClickListener {
            viewModel.delete(item)
        }

        holder.binding.ivPlus.setOnClickListener {
            item.mount++
            viewModel.upsert(item)
        }

        holder.binding.ivMinus.setOnClickListener {
            if (item.mount > 0) {
                item.mount--
                viewModel.upsert(item)
            }
        }
    }
}