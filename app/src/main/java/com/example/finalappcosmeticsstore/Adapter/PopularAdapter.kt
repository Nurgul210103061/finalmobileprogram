package com.example.finalappcosmeticsstore.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalappcosmeticsstore.DetailsActivity
import com.example.finalappcosmeticsstore.Models.PopularModel
import com.example.finalappcosmeticsstore.databinding.HomeCatalogItemBinding

class PopularAdapter(
    val context : Context,
    val list : ArrayList<PopularModel>
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularAdapter.PopularViewHolder {
        val binding = HomeCatalogItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return PopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularAdapter.PopularViewHolder, position: Int) {

        val listModel = list[position]

          holder.catalogName.text = listModel.getCatalogName()
          holder.catalogPrice.text =listModel.getCatalogPrice()
          listModel.getCatalogImage()?.let {holder.catalogImage.setImageResource(it)}

            holder.item.setOnClickListener{
                val intent = Intent(context, DetailsActivity :: class.java)
                intent.putExtra("catalogImage", listModel.getCatalogImage())
                intent.putExtra("catalogName", listModel.getCatalogName())
                context.startActivity(intent)
            }
    }

    override fun getItemCount(): Int {
       return list.size
    }

    class PopularViewHolder(binding: HomeCatalogItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val catalogImage = binding.homeCatalogImage
        val catalogName = binding.homeCatalogName
        val catalogPrice = binding.homeCatalogPrice
        val item = binding.root

    }
}