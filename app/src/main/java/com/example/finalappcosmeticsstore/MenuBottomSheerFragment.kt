package com.example.finalappcosmeticsstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalappcosmeticsstore.Adapter.PopularAdapter
import com.example.finalappcosmeticsstore.Models.PopularModel
import com.example.finalappcosmeticsstore.Models.SharedModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheerFragment : BottomSheetDialogFragment() {
    private lateinit var adapter : PopularAdapter
    private lateinit var menuList : ArrayList<PopularModel>
    private lateinit var menuRV : RecyclerView
    private lateinit var sharedModel: SharedModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_menu_bottom_sheer, container, false)

        sharedModel = ViewModelProvider(requireActivity()).get(SharedModel :: class.java)
        menuList = ArrayList()
        menuList.add(PopularModel(R.drawable.recycrelimage1,"Aloe Vera",2179,2179,1))
        menuList.add(PopularModel(R.drawable.recycrelimage2,"Beauty of Joseon Relief Sun",12000,12000,1))
        menuList.add(PopularModel(R.drawable.recycrelimage3,"Collagen ",3590,3590,1))
        menuList.add(PopularModel(R.drawable.recycrelimage4,"Doctor Cr.",7610,7610,1))
        menuList.add(PopularModel(R.drawable.recycrelimage5,"BH serum",8500,8500,1))
        menuList.add(PopularModel(R.drawable.recycrelimage6,"Baking Powder",4300,4300,1))
        menuList.add(PopularModel(R.drawable.recycrelimage7,"Zero",5500,5500,1))
        menuList.add(PopularModel(R.drawable.recycrelimage8,"Joseon Relief Sun serum",2179,2179,1))
        menuList.add(PopularModel(R.drawable.recycrelimage9,"Hand Cream",3460,3460,1))
        menuList.add(PopularModel(R.drawable.recycrelimage10,"Peeling Gel",2179,2179,1))
        adapter = PopularAdapter(requireContext(),menuList)
        adapter.setSharedModel(sharedModel)

        menuRV = view.findViewById(R.id.menu_RV)
        menuRV.layoutManager = LinearLayoutManager(requireContext())
        menuRV.adapter = adapter

        return view
    }


}