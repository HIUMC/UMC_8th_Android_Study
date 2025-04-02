package com.example.test02

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.test02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val handler = Handler(Looper.getMainLooper())

        val imageList = arrayListOf<Int>()

        imageList.add(R.drawable.bear)
        imageList.add(R.drawable.duck)
        imageList.add(R.drawable.dog)
        imageList.add(R.drawable.bear)
        imageList.add(R.drawable.duck)
        imageList.add(R.drawable.dog)
        imageList.add(R.drawable.bear)
        imageList.add(R.drawable.duck)
        imageList.add(R.drawable.dog)

        Thread{
            for(image in imageList){
//                handler.post{
//                    binding.iv.setImageResource(image)
//                }
                runOnUiThread{
                    binding.iv.setImageResource(image)
                }
                Thread.sleep(2000)
            }
        }.start()
    }
}