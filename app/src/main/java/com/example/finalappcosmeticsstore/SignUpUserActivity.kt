package com.example.finalappcosmeticsstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finalappcosmeticsstore.databinding.ActivitySignUpUserBinding

class SignUpUserActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignUpUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpUserBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_sign_up_user)

        binding.goLoginUserPage.setOnClickListener{
            val intent = Intent(this@SignUpUserActivity,LoginUserActivity :: class.java)
            startActivity(intent)
        }

        binding.button3.setOnClickListener{
            val intent = Intent(this@SignUpUserActivity, LocationActivity :: class.java)
        }
    }
}