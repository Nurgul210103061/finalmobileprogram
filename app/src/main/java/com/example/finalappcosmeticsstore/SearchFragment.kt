package com.example.finalappcosmeticsstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalappcosmeticsstore.Adapter.PopularAdapter
import com.example.finalappcosmeticsstore.Models.PopularModel
import com.example.finalappcosmeticsstore.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding : FragmentSearchBinding
    private lateinit var adapter : PopularAdapter
    private lateinit var list : ArrayList<PopularModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)


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

        adapter = PopularAdapter(requireContext(),list)

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

