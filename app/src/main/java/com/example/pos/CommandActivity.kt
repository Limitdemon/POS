package com.example.pos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CommandActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_command)

        val LogOr = findViewById<Button>(R.id.OrderActivitybtn)

        LogOr.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }

        val LogAd = findViewById<Button>(R.id.ProductCRUDActivitybtn)

        LogAd.setOnClickListener {
             val intent = Intent(this, ProductCRUDActivity::class.java)
             startActivity(intent)
        }

    }
}