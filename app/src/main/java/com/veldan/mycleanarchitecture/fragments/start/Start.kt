package com.veldan.mycleanarchitecture.fragments.start

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.veldan.mycleanarchitecture.databinding.FragmentStartBinding

class Start : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initBinding()
        
        return binding.root
    }

    // {init}: Binding
    private fun initBinding() {
        binding = FragmentStartBinding.inflate(layoutInflater)
    }

}