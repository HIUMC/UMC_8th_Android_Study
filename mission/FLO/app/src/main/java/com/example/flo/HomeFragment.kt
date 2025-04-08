package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.homeAlbumImgIv1.setOnClickListener {
            //프래그먼트를 어디에서 변경할 것인지 써주는 작업
            (context as MainActivity).supportFragmentManager.beginTransaction()
                //앨범 프래그먼트로 대체하겠다.
                .replace(R.id.main_frm , AlbumFragment())
                //내부적으로 동작하는 부분이어서... 어려울 수 있음. 이렇게 사용한다~ 정도로 알고 있자.
                .commitAllowingStateLoss()
        }

        return binding.root
    }


}