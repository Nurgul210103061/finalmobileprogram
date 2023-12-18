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

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartViewHolder {
        val binding = CartAddItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {

        val listModel = list[position]

        holder.catalogName.text = listModel.getCatalogName()
        holder.catalogPrice.text = listModel.getCatalogPrice()
        listModel.getCatalogImage()?.let { holder.catalogImage.setImageResource(it) }
    }

    override fun getItemCount(): Int {
       return list.size
    }

    inner class CartViewHolder(binding:CartAddItemBinding):
            RecyclerView.ViewHolder(binding.root){
            val catalogImage = binding.homeCatalogImage
            val catalogName = binding.homeCatalogName
            val catalogPrice = binding.homeCatalogPrice

            val plus = binding.plusBtn
            val minus = binding.minusBtn

            }
}