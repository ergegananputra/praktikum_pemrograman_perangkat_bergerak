package com.ppb.tugaspertemuan5

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.ppb.tugaspertemuan5.databinding.ActivityRegisterBinding

class ActivityRegister : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            buttonRegister.setOnClickListener {
                if (editTextUsername.text.toString().isEmpty()) {
                    editTextUsername.error = "Mohon masukkan username"
                    return@setOnClickListener
                }
                if (editTextEmail.text.toString().isEmpty()) {
                    editTextEmail.error = "Mohon masukkan email"
                    return@setOnClickListener
                }
                if (editTextPhone.text.toString().isEmpty()) {
                    editTextPhone.error = "Mohon masukkan nomor telepon"
                    return@setOnClickListener
                }
                if (editTextPassword.text.toString().isEmpty()) {
                    editTextPassword.error = "Mohon buat password dengan benar"
                    return@setOnClickListener
                }

                val intentToHonePage = Intent(this@ActivityRegister, MainActivity::class.java)
                intentToHonePage.putExtra(EXTRA_USERNAME, editTextUsername.text.toString())
                editTextUsername.setText("")
                intentToHonePage.putExtra(EXTRA_EMAIL, editTextEmail.text.toString())
                editTextEmail.setText("")
                intentToHonePage.putExtra(EXTRA_PHONE, editTextPhone.text.toString())
                editTextPhone.setText("")
                editTextPassword.setText("")
                editTextPassword.clearFocus()
                startActivity(intentToHonePage)
            }

            linkTerms.setOnClickListener {
                terms()
            }

            linkConditions.setOnClickListener {
                condition()
            }

            linkLogin.setOnClickListener {
                login()
            }


        }
    }

    fun login() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://youtu.be/dQw4w9WgXcQ?feature=shared")
        startActivity(intent)
        Log.d("Login", "Login button clicked")
    }
    fun condition() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://youtu.be/dQw4w9WgXcQ?feature=shared")
        startActivity(intent)
        Log.d("Login", "Condition button clicked")
    }
    fun terms() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://youtu.be/dQw4w9WgXcQ?feature=shared")
        startActivity(intent)
        Log.d("Login", "Terms button clicked")
    }
}