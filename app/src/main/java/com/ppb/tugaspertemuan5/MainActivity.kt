package com.ppb.tugaspertemuan5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ppb.tugaspertemuan5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            val username = intent.getStringExtra(ActivityRegister.EXTRA_USERNAME)
            val email = intent.getStringExtra(ActivityRegister.EXTRA_EMAIL)
            val phone = intent.getStringExtra(ActivityRegister.EXTRA_PHONE)

            textViewMessageActivation.text = "Welcome $username \nYour $email has been activated \nYour $phone has been registered"

            buttonLogout.setOnClickListener {
                finish()
            }
        }
    }
}