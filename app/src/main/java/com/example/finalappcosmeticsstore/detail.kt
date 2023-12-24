package com.example.finalappcosmeticsstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finalappcosmeticsstore.databinding.ActivityDetailBinding
import com.example.finalappcosmeticsstore.databinding.ActivityDetailsBinding

class detail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backStack.setOnClickListener{
            onBackPressed()
        }
        binding.placeMyOrder.setOnClickListener{
            val bottomFragment = SuccessPayment()
            bottomFragment.show(supportFragmentManager, "Test")
        }
        val totalPrice = intent.getStringExtra("totalPrice")
        binding.price.text = totalPrice
    }
}