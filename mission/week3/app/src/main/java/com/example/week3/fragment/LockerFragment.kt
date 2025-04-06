package com.example.week3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.week3.adapter.LockerVPAdapter
import com.example.week3.databinding.FragmentLockerBinding
import com.google.android.material.tabs.TabLayoutMediator

class LockerFragment : Fragment() {

    lateinit var binding: FragmentLockerBinding
    private val tabInfo: ArrayList<String> = arrayListOf("저장한 곡", "음악파일")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLockerBinding.inflate(inflater, container, false)

        val lockerAdapter = LockerVPAdapter(this)
        binding.lockerContentVp.adapter = lockerAdapter
        binding.lockerContentVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        TabLayoutMediator(binding.lockerContentTb, binding.lockerContentVp) {
                tab, position ->
            tab.text = tabInfo[position] // 탭뷰의 아이템 이름 설정
        }.attach() // 탭뷰와 vp 연결

        return binding.root
    }
}