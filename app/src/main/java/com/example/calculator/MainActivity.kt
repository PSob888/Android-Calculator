package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSimple = findViewById<Button>(R.id.buttonsimple)
        buttonSimple.setOnClickListener {
            val intent = Intent(this, SimpleActivity::class.java)
            startActivity(intent)
        }

        val buttonAdvanced = findViewById<Button>(R.id.buttonadvanced)
        buttonAdvanced.setOnClickListener {
            val intent = Intent(this, AdvancedActivity::class.java)
            startActivity(intent)
        }

        val buttonAbout = findViewById<Button>(R.id.buttonabout)
        buttonAbout.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        val buttonExit = findViewById<Button>(R.id.buttonexit)
        buttonExit.setOnClickListener {
            finish();
            exitProcess(0);
        }
    }
}