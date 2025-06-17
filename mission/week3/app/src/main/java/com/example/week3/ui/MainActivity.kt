package com.example.week3.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.week3.R
import com.example.week3.databinding.ActivityMainBinding
import com.example.week3.model.Song
import com.example.week3.ui.main.HomeFragment
import com.example.week3.ui.main.LockerFragment
import com.example.week3.ui.main.LookFragment
import com.example.week3.ui.main.SearchFragment
import com.example.week3.ui.player.SongActivity
import com.example.week3.ui.player.SongActivity.Timer
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val gson: Gson = Gson()
    private var song: Song = Song()
    private var mediaPlayer: MediaPlayer? = null
    lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Flo)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupMainPlayerClickListener()
        initBottomNavigation()
        startTimer()

        // 재생-정지 아이콘에 대한 클릭 리스너
        binding.mainMiniplayerBtn.setOnClickListener {
            setPlayerStatus(true)
        }
        binding.mainPauseBtn.setOnClickListener {
            setPlayerStatus(false)
        }
    }

    private fun setupMainPlayerClickListener() {
        binding.mainMiniPlayerToSongLl.setOnClickListener {
            timer.interrupt()
            mediaPlayer?.release() // 미디어플레이어 리소스 해제
            mediaPlayer = null
            //startActivity(Intent(this, SongActivity::class.java))
            val intent = Intent(this, SongActivity::class.java)
            intent.putExtra("title", song.title)
            intent.putExtra("singer", song.singer)
            intent.putExtra("cover", song.cover)
            intent.putExtra("second", song.second)
            intent.putExtra("playTime", song.playTime)
            intent.putExtra("isPlaying", song.isPlaying)
            intent.putExtra("music", song.music)
            startActivity(intent)
        }
    }

    private fun initBottomNavigation() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.lookFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, LookFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.searchFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.lockerFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, LockerFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

    override fun onStart() {
        super.onStart()
        val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
        val songJson = sharedPreferences.getString("songData", null)

        song = if (songJson == null) {
            Song("라일락", "아이유", R.drawable.img_album_exp2, 0, 60, false, R.raw.music_piano)
        } else {
            gson.fromJson(songJson, Song::class.java)
        }

        setMiniPlayer(song)
    }

    private fun setMiniPlayer(song: Song) {
        binding.mainMiniPlayerTitleTv.text = song.title
        binding.mainMiniPlayerSingerTv.text = song.singer
        binding.mainSongProgressSb.progress = (song.second * 1000) / song.playTime

        mediaPlayer = MediaPlayer.create(this, song.music)

        setPlayerStatus(song.isPlaying)
    }

    // 플레이어 재생-정지 버튼 설정
    private fun setPlayerStatus(isPlaying: Boolean) {
        song.isPlaying = isPlaying
        timer.isPlaying = isPlaying

        if (isPlaying) {
            // 현 상태: 음악 재생중 (아이콘: 멈추기 버튼) - 이게 구현되어야 함
            // 기대 값: 음악 멈춤 (아이콘: 재생 버튼)
            binding.mainMiniplayerBtn.visibility = View.GONE
            binding.mainPauseBtn.visibility = View.VISIBLE
            mediaPlayer?.start()
        } else {
            // 현 상태: 음악 멈춤 (아이콘: 재생 버튼) - 이게 구현되어야 함
            // 기대 값: 음악 재생 (아이콘: 멈추기 버튼)
            binding.mainMiniplayerBtn.visibility = View.VISIBLE
            binding.mainPauseBtn.visibility = View.GONE
            if (mediaPlayer?.isPlaying == true) { // 없으면 오류 발생 가능성 있음.
                mediaPlayer?.pause()
            }
        }
    }

    private fun startTimer() {
        timer = Timer(playTime = song.playTime, isPlaying = song.isPlaying)
        timer.start()
    }

    inner class Timer(private val playTime: Int, var isPlaying: Boolean = true): Thread()  {
        private var second: Int = song.second
        private var mills: Float = second.times(1000f)

        @SuppressLint("DefaultLocale")
        override fun run() {
            super.run()
            try {
                while (true) {
                    if (second >= playTime) {
                        break
                    }

                    if (isPlaying) {
                        sleep(50)
                        mills += 50

                        runOnUiThread {
                            binding.mainSongProgressSb.progress = (((mills) / playTime)*100).toInt()
                        }

                        if (mills % 1000 == 0f) {
                            second++
                        }
                    }
                }
            } catch (e: InterruptedException) {
                Log.d("Song", "Thread 죽음: ${e.message}")
            }

        }
    }
}