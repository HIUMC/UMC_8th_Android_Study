package com.example.week3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.week3.databinding.FragmentBannerBinding

class BannerFragment(
    val imgRes : Int
): Fragment() {

    lateinit var binding: FragmentBannerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBannerBinding.inflate(layoutInflater)

        binding.bannerImgIv.setImageResource(imgRes)

        return binding.root
    }
}