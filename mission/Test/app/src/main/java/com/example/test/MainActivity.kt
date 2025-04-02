package com.example.test

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val layout1 = this.findViewById<ImageView>(R.id.emoji1)
        layout1.setOnClickListener{
            val intent = Intent(this,Emoji1::class.java)
            startActivity(intent)
        }

        val layout2 = this.findViewById<ImageView>(R.id.emoji2)
        layout2.setOnClickListener{
            val intent2 = Intent(this,Emoji2::class.java)
            startActivity(intent2)
        }

        val layout3 = this.findViewById<ImageView>(R.id.emoji3)
        layout3.setOnClickListener {
            val intent3 = Intent(this,Emoji3::class.java)
            startActivity(intent3)
        }

        val layout4 = this.findViewById<ImageView>(R.id.emoji4)
        layout4.setOnClickListener {
            val intent4 = Intent(this,Emoji4::class.java)
            startActivity(intent4)
        }

        val layout5 = this.findViewById<ImageView>(R.id.emoji5)
        layout5.setOnClickListener {
            val intent5 = Intent(this,Emoji5::class.java)
            startActivity(intent5)
        }
    }
}