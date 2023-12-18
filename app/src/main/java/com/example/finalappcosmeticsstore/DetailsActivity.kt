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

        val catalogImage = intent.getIntExtra("CatalogImage", 0)
        val catalogName = intent.getStringExtra("CatalogName")

        binding.menuDCosImage.setImageResource(catalogImage)
        binding.menuDName.text = catalogName
        binding.backHome.setOnClickListener{
            finish()
        }
    }
}

