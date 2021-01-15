package com.bhumika.softuser_week6

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var etusername : EditText
    private lateinit var etpassword : EditText
    private lateinit var btnlog : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etusername = findViewById(R.id.etusername)
        etpassword = findViewById(R.id.etpassword)
        btnlog = findViewById(R.id.btnlog)
        btnlog.setOnClickListener {
            if(validate()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
    private fun validate() : Boolean {
        when {
            TextUtils.isEmpty(etusername.text) -> {
                etusername.error = "Username must not be empty"
                etusername.requestFocus()
                return false
            }
            etusername.text.toString() != "softwarica" -> {
                etusername.error = "Username is incorrect."
                etusername.requestFocus()
                return false
            }
            TextUtils.isEmpty(etpassword.text) -> {
                etpassword.error = "Password must not be empty"
                etpassword.requestFocus()
                return false
            }
            etpassword.text.toString() != "coventry" -> {
                etpassword.error = "Password is incorrect."
                etpassword.requestFocus()
                return false
            }
            else -> return true
        }

    }
}