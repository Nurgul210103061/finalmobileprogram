package com.example.finalappcosmeticsstore

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.finalappcosmeticsstore.Adapter.ImageSliderAdapter


class HomeFragment : Fragment() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: ImageSliderAdapter
    private lateinit var imageList: ArrayList<Int>
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        viewPager2 = view.findViewById(R.id.imageSlider)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setTransfarmer()
    }

    private fun setTransfarmer() {

        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(10))
        transformer.addTransformer{page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f - r * 0.14f
        }

        viewPager2.setPageTransformer(transformer)
    }

    private fun init() {
        imageList = ArrayList()
        adapter = ImageSliderAdapter(requireContext(),imageList,viewPager2)
        handler = Handler(Looper.myLooper()!!)
    }
}
