package com.juanma.intentexample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Explicit Intentr
        val expliciButton = findViewById<Button>(R.id.expliciButton)
        expliciButton.setOnClickListener{
            val explicitIntent = Intent(this, SecondActivity::class.java)
            startActivity(explicitIntent)
        }

        //Implicit Intentr
        val url = "https://www.google.com"
        val impliciButton = findViewById<Button>(R.id.impliciButton)
        impliciButton.setOnClickListener{
            val implicitIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(implicitIntent)
        }
    }
}