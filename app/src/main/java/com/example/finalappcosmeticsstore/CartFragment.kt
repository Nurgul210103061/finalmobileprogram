package com.example.finalappcosmeticsstore

import android.content.Intent
import android.os.Bundle
import android.telecom.Call.Details
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalappcosmeticsstore.Adapter.CartAdapter
import com.example.finalappcosmeticsstore.Models.PopularModel
import com.example.finalappcosmeticsstore.Models.SharedModel
import com.example.finalappcosmeticsstore.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding : FragmentCartBinding
    private lateinit var sharedModel: SharedModel
    //private lateinit var list : ArrayList<PopularModel>
    private lateinit var adapter: CartAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater,container,false)


        sharedModel = ViewModelProvider(requireActivity()).get(SharedModel :: class.java)


        adapter = CartAdapter(requireContext(),sharedModel.cartItem.value ?: ArrayList())

        binding.cartRv.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRv.adapter = adapter

        binding.proceedBtn.setOnClickListener{
            val totalPrice = sharedModel.cartItem.value?.let { it1 -> colPrice(it1) }
            if(totalPrice == 0){
                Toast.makeText(requireContext(),"List is Empty", Toast.LENGTH_SHORT).show()
            }
            val TotalPrice = totalPrice.toString()
            val intent = Intent(requireContext(), detail :: class.java)
            intent.putExtra("totalPrice",TotalPrice)
            startActivity(intent)
        }
        return binding.root
    }
    fun colPrice(itemPrices : List<PopularModel>) : Int{

        var totalPrice = 0

        itemPrices.forEach{ itemPrice ->

            val price = itemPrice.getCatalogPriceConstant() * itemPrice.getCatalogCount()
            totalPrice += price

        }
        return totalPrice
    }


}

