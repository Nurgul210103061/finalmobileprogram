package com.example.finalappcosmeticsstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalappcosmeticsstore.Adapter.PopularAdapter
import com.example.finalappcosmeticsstore.Models.PopularModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheerFragment : BottomSheetDialogFragment() {
    private lateinit var adapter : PopularAdapter
    private lateinit var menuList : ArrayList<PopularModel>
    private lateinit var menuRV : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_menu_bottom_sheer, container, false)
        menuList = ArrayList()
        menuList.add(PopularModel(R.drawable.recycrelimage1,"Aloe Vera","2179tg"))
        menuList.add(PopularModel(R.drawable.recycrelimage2,"Beauty of Joseon Relief Sun","12000tg"))
        menuList.add(PopularModel(R.drawable.recycrelimage3,"Collagen ","3590tg"))
        menuList.add(PopularModel(R.drawable.recycrelimage4,"Doctor Cr.","7610tg"))
        menuList.add(PopularModel(R.drawable.recycrelimage5,"BH serum","8500tg"))
        menuList.add(PopularModel(R.drawable.recycrelimage6,"Baking Powder","4300tg"))
        menuList.add(PopularModel(R.drawable.recycrelimage7,"Zero","5500tg"))
        menuList.add(PopularModel(R.drawable.recycrelimage8,"Joseon Relief Sun serum","2179tg"))
        menuList.add(PopularModel(R.drawable.recycrelimage9,"Hand Cream","3460tg"))
        menuList.add(PopularModel(R.drawable.recycrelimage10,"Peeling Gel","2179tg"))
        adapter = PopularAdapter(requireContext(),menuList)

        menuRV = view.findViewById(R.id.menu_RV)
        menuRV.layoutManager = LinearLayoutManager(requireContext())
        menuRV.adapter = adapter
        return view
    }


}