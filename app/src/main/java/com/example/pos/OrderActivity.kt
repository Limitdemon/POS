package com.example.pos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val LogM = findViewById<Button>(R.id.MacaronActivitybtn)

        LogM.setOnClickListener {
            val intent = Intent(this, MacaronActivity::class.java)
            intent.putExtra("CatID", MACARON_CONNNID)
            startActivity(intent)

        }
    }
}