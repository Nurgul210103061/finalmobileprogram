package com.example.finalappcosmeticsstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalappcosmeticsstore.Adapter.PopularAdapter
import com.example.finalappcosmeticsstore.Models.PopularModel
import com.example.finalappcosmeticsstore.Models.SharedModel
import com.example.finalappcosmeticsstore.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding : FragmentSearchBinding
    private lateinit var adapter : PopularAdapter
    private lateinit var list : ArrayList<PopularModel>
    private lateinit var sharedModel: SharedModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        sharedModel = ViewModelProvider(requireActivity()).get(SharedModel :: class.java)

        list = ArrayList()
        list.add(PopularModel(R.drawable.recycrelimage1,"Aloe Vera",2179,2179,1))
        list.add(PopularModel(R.drawable.recycrelimage2,"Beauty of Joseon Relief Sun",12000,12000,1))
        list.add(PopularModel(R.drawable.recycrelimage3,"Collagen ",3590,3590,1))
        list.add(PopularModel(R.drawable.recycrelimage4,"Doctor Cr.",7610,7610,1))
        list.add(PopularModel(R.drawable.recycrelimage5,"BH serum",8500,8500,1))
        list.add(PopularModel(R.drawable.recycrelimage6,"Baking Powder",4300,4300,1))
        list.add(PopularModel(R.drawable.recycrelimage7,"Zero",5500,5500,1))
        list.add(PopularModel(R.drawable.recycrelimage8,"Joseon Relief Sun serum",2179,2179,1))
        list.add(PopularModel(R.drawable.recycrelimage9,"Hand Cream",3460,3460,1))
        list.add(PopularModel(R.drawable.recycrelimage10,"Peeling Gel",2179,2179,1))

        adapter = PopularAdapter(requireContext(),list)
        adapter.setSharedModel(sharedModel)

        binding.searchMenuRv.layoutManager = LinearLayoutManager(requireContext())
        binding.searchMenuRv.adapter = adapter
        searchMenuCatalog()
        return binding.root

    }
    private fun searchMenuCatalog(){
        binding.searchCatalogItem.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterList(query)
               return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
               return true
            }
        })
    }

    private fun filterList(input : String?){
        val filteredList = if (input.isNullOrEmpty()) {
            list
        }else{
            list.filter { item ->
                item.getCatalogName().contains(input, ignoreCase = true)
            }
        }
       adapter.updateList(filteredList as ArrayList<PopularModel>)
    }
}

