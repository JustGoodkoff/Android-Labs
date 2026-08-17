package ru.nsu.aagudkov.lab4

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text: TextView = findViewById(R.id.text)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener{
            if (text.text.toString() != "12345") {
                ObjectAnimator.ofFloat(text, "translationX", 0f, 100f, -90f, 80f, -70f, 60f, -50f, 40f, -30f, 20f, -10f, 0f).apply {
                    duration = 3000
                    start()
                }
            }
        }
    }
}