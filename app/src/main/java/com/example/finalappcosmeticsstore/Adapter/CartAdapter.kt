package com.example.finalappcosmeticsstore.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalappcosmeticsstore.Adapter.CartAdapter.CartViewHolder
import com.example.finalappcosmeticsstore.Models.PopularModel
import com.example.finalappcosmeticsstore.databinding.CartAddItemBinding
import com.example.finalappcosmeticsstore.databinding.HomeCatalogItemBinding

class CartAdapter(
    val context : Context,
    val list : ArrayList<PopularModel>
) : RecyclerView.Adapter<CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartAddItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {

        val listModel = list[position]

        holder.catalogName.text = listModel.getCatalogName()
        holder.catalogPrice.text = listModel.getCatalogPrice().toString()
        listModel.getCatalogImage()?.let { holder.catalogImage.setImageResource(it) }
        holder.catalogCount.text = listModel.getCatalogCount().toString()

        holder.plus.setOnClickListener{
            if (listModel.getCatalogCount() < 10){
                val count = listModel.getCatalogCount() + 1
                listModel.setCatalogCount(count)
                val price = listModel.getCatalogPriceConstant() * listModel.getCatalogCount()
                listModel.setCatalogPrice(price)
                holder.catalogPrice.text=listModel.getCatalogPrice().toString()
                holder.catalogCount.text = listModel.getCatalogCount().toString()
            }
        }

        holder.minus.setOnClickListener{
            if (listModel.getCatalogCount() > 1) {
                val count = listModel.getCatalogCount() - 1
                listModel.setCatalogCount(count)
                val price = listModel.getCatalogPriceConstant() * listModel.getCatalogCount()
                listModel.setCatalogPrice(price)
                holder.catalogPrice.text=listModel.getCatalogPrice().toString()
                holder.catalogCount.text = listModel.getCatalogCount().toString()
            }
            else{
                holder.bindItem()
            }

            }
        holder.deleteBtn.setOnClickListener{
            holder.bindItem()
        }

    }

    override fun getItemCount(): Int {
       return list.size
    }

    inner class CartViewHolder(binding:CartAddItemBinding):
            RecyclerView.ViewHolder(binding.root){

            val catalogImage = binding.homeCatalogImage
            val catalogName = binding.homeCatalogName
            val catalogPrice = binding.homeCatalogPrice
            val catalogCount = binding.catalogCount

            val plus = binding.plusBtn
            val minus = binding.minusBtn
            val deleteBtn = binding.deleteBtn

            fun bindItem(){
                if (adapterPosition != RecyclerView.NO_POSITION){
                    deleteItem(adapterPosition)
                }
            }
            }
    fun deleteItem(position: Int){
        if (position in 0..list.size){
            list.removeAt(position)
            notifyDataSetChanged()
            notifyItemRangeChanged(position, list.size)
        }
    }
}