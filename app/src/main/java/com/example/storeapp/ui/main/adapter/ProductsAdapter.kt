package com.example.storeapp.ui.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.storeapp.data.models.Product
import com.example.storeapp.databinding.ItemProductBinding

class ProductsAdapter (val data: List<Product>)
    : ListAdapter<Product, ProductsAdapter.MyViewHolder>(UserItemDiffCallback()) {

    class MyViewHolder(val binding: ItemProductBinding) : ViewHolder(binding.root) {
        companion object{
            fun from(parent: ViewGroup) : MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemProductBinding.inflate(layoutInflater,parent,false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvName.text=data.get(position).title
        holder.binding.tvDesc.text=data.get(position).description
        holder.binding.tvPrice.text="$${data.get(position).price}"
        holder.binding.rating.rating=data.get(position).rating.toFloat()
        Glide.with(holder.itemView.context).load(data.get(position).images.get(0)).into(holder.binding.ivProduct)
    }
}

class UserItemDiffCallback: DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

}