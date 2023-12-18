package com.example.finalappcosmeticsstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finalappcosmeticsstore.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodImage = intent.getIntExtra("foodImage", 0)
        val foodName = intent.getStringExtra("foodName")

        binding.menuDCosImage.setImageResource(foodImage)
        binding.menuDName.text = foodName
        binding.backHome.setOnCLickListener{
            finish()
        }
    }
}

