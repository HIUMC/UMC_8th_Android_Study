package com.example.week3.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.week3.MainActivity
import com.example.week3.R
import com.example.week3.Song
import com.example.week3.adapter.BannerVPAdapter
import com.example.week3.adapter.PanelVPAdapter
import com.example.week3.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.homeAlbum1Lo.setOnClickListener {
            (context as MainActivity)
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_frm, AlbumFragment()) // 바꿀 곳(메인 액티비티의 프래그먼트 프레임 아이디) - 무엇으로 바꿀 지
                .commitAllowingStateLoss()
        }

        val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 가로방향 페이지 이동

        val song1 = Song("Butter", "BTS", R.drawable.img_album_exp)
        val song2 = Song("LILAC", "아이유 (IU)", R.drawable.img_album_exp2)
        val song3 = Song("Next Level", "에스파", R.drawable.img_album_exp3)
        val song4 = Song("작은 것들을 위한 시", "BTS", R.drawable.img_album_exp4)
        val song5 = Song("BAAM", "모모랜드", R.drawable.img_album_exp5)
        val song6 = Song("Weekend", "태연", R.drawable.img_album_exp6)

        val panelAdapter = PanelVPAdapter(this)
        panelAdapter.addFragment(
            PlaylistRecommendFragment(
                title = "BTS와 함께하는\n 플레이리스트 \uD83D\uDC9C",
                songList = arrayListOf(song1, song4)
            )
        )
        panelAdapter.addFragment(
            PlaylistRecommendFragment(
                title = "마른 감성을 촉촉하게\n해줄 여성 솔로 음악",
                songList = arrayListOf(song2, song6)
            )
        )
        panelAdapter.addFragment(
            PlaylistRecommendFragment(
                title = "최신 걸그룹 케이팝\n플레이리스트",
                songList = arrayListOf(song3, song5)
            )
        )
        binding.homePanelBackgroundVp.adapter = panelAdapter
        binding.homePanelBackgroundVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 가로방향 페이지 이동

        val indicator = binding.indicator
        indicator.setViewPager(binding.homePanelBackgroundVp)

        return binding.root
    }
}