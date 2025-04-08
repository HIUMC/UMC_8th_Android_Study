package com.example.week3.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.week3.fragment.SavedMusicFragment
import com.example.week3.fragment.DeviceMusicFragment

class LockerVPAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SavedMusicFragment()
            else -> DeviceMusicFragment()
        }
    }
}