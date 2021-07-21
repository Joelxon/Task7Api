package com.joelson.task7api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joelson.task7api.databinding.ItemListBinding
import com.joelson.task7api.model.ItemModel

class ItemAdapter(var items: List<ItemModel>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item: ItemModel){
            binding.itemName.text = item.name
            binding.itemPrice.text = item.price.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding: ItemListBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}