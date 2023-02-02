package com.example.pos

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class LogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        val preferE = getPreferences(Context.MODE_PRIVATE)
        val name = preferE.getString("UN", "")
        val pass = preferE.getString("PW", "")

        val fieldName = findViewById(R.id.editTextTextPersonName) as TextView
        val fieldPass = findViewById(R.id.editTextTextPassword) as TextView
        val checkBox = findViewById(R.id.checkBox) as CheckBox

        fieldName.setText(name)
        fieldPass.setText(pass)

        if (preferE.getBoolean("RememberMe" , false)) {
            checkBox.setChecked(true)
        } else {
            checkBox.setChecked(false)
        }

        val LogB = findViewById<Button>(R.id.CommandActivitybtn)

        LogB.setOnClickListener {

            val checkBox = findViewById(R.id.checkBox) as CheckBox

            if (checkBox.isChecked) {
                val preferences = getPreferences(Context.MODE_PRIVATE)
                val edit = preferences.edit()


                edit.putString("UN", fieldName.text.toString())
                edit.putString("PW", fieldPass.text.toString())
                edit.putBoolean("RememberMe", true)
                edit.commit()

                //Show this message on screen
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
            }

            Toast.makeText(this, "Korakrod has clicked the login button", Toast.LENGTH_SHORT).show()


            val intent = Intent(this, CommandActivity::class.java)
            startActivity(intent)
        }
        val textS = findViewById<TextView>(R.id.Settingbtn)

       textS.setOnVeryLongClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
           true

        }
    }
    fun View.setOnVeryLongClickListener(listener: () -> Unit) {
        setOnTouchListener(object : View.OnTouchListener {

            private val longClickDuration = 6000L
            private val handler = Handler()

            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                if (event?.action == MotionEvent.ACTION_DOWN) {
                    handler.postDelayed({ listener.invoke() }, longClickDuration)
                } else if (event?.action == MotionEvent.ACTION_UP) {
                    handler.removeCallbacksAndMessages(null)
                }
                return true
            }
        })
    }
}