package com.example.finalappcosmeticsstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.finalappcosmeticsstore.databinding.ActivityLoginUserBinding

class LoginUserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goSignUpUser.setOnClickListener{
            val intent = Intent(this@LoginUserActivity, SignUpUserActivity :: class.java)
            startActivity(intent)
        }
    }
}


