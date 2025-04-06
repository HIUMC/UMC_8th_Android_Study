package com.example.week3

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.week3.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {

    lateinit var binding: ActivitySongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.songBtnPlayerCloseIb.setOnClickListener {
            finish()
        }

        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(false)
        }
        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(true)
        }

        if (intent.hasExtra("title") && intent.hasExtra("singer") && intent.hasExtra("cover")) {
            binding.songTitleTv.text = intent.getStringExtra("title")
            binding.songSingerTv.text = intent.getStringExtra("singer")

            val resId = intent.getIntExtra("cover", -1)
            if (resId != -1) {
                binding.songCoverIv.setImageResource(resId)
            }
        }

        var isRepeat = false
        binding.songRepeatIv.setOnClickListener {
            isRepeat = !isRepeat

            if (isRepeat) {
                binding.songRepeatIv.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.select_color
                    )
                )
            } else {
                binding.songRepeatIv.clearColorFilter()
            }
        }

        var isRandom = false
        binding.songRandomIv.setOnClickListener {
            isRandom = !isRandom

            if (isRandom) {
                binding.songRandomIv.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.select_color
                    )
                )
            } else {
                binding.songRandomIv.clearColorFilter()
            }
        }
    }

    fun setPlayerStatus(isPlaying: Boolean) {
        if (isPlaying) {
            // 현 상태: 음악 재생중 (아이콘: 멈추기 버튼)
            // 기대 값: 음악 멈춤 (아이콘: 재생 버튼)
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        } else {
            // 현 상태: 음악 멈춤 (아이콘: 재생 버튼)
            // 기대 값: 음악 재생 (아이콘: 멈추기 버튼)
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        }


    }
}