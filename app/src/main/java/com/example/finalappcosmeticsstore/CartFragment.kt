package com.example.finalappcosmeticsstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalappcosmeticsstore.Adapter.CartAdapter
import com.example.finalappcosmeticsstore.Models.PopularModel
import com.example.finalappcosmeticsstore.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding : FragmentCartBinding

    private lateinit var list : ArrayList<PopularModel>
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

        list = ArrayList()
        list.add(PopularModel(R.drawable.recycrelimage1,"Aloe Vera","2179tg"))
        list.add(PopularModel(R.drawable.recycrelimage2,"Beauty of Joseon Relief Sun","12000tg"))
        list.add(PopularModel(R.drawable.recycrelimage3,"Collagen ","3590tg"))
        list.add(PopularModel(R.drawable.recycrelimage4,"Doctor Cr.","7610tg"))
        list.add(PopularModel(R.drawable.recycrelimage5,"BH serum","8500tg"))
        list.add(PopularModel(R.drawable.recycrelimage6,"Baking Powder","4300tg"))
        list.add(PopularModel(R.drawable.recycrelimage7,"Zero","5500tg"))
        list.add(PopularModel(R.drawable.recycrelimage8,"Joseon Relief Sun serum","2179tg"))
        list.add(PopularModel(R.drawable.recycrelimage9,"Hand Cream","3460tg"))
        list.add(PopularModel(R.drawable.recycrelimage10,"Peeling Gel","2179tg"))


        adapter = CartAdapter(requireContext(),list)

        binding.cartRv.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRv.adapter = adapter
        return binding.root
    }

}