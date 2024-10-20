package com.example.lab2_1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val nextBtn: Button = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener {
            val intent: Intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}