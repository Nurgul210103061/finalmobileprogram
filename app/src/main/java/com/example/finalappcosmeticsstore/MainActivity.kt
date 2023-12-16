package com.example.finalappcosmeticsstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.finalappcosmeticsstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home -> {
                    changeFragment(HomeFragment())
                }
            }
        }
    }
    fun changeFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}

