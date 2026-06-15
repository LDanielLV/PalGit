package com.example.palgit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnFragment = findViewById<Button>(R.id.btnFragmentApp)
        val btnTacos = findViewById<Button>(R.id.btnTacos)
        btnTacos.setOnClickListener {
            val intentTacos = Intent(this, TacosActivity::class.java)
            startActivity(intentTacos)
        }
        btnFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, RegistroFragment())
                .addToBackStack(null)
                .commit()
        }
    }

}
