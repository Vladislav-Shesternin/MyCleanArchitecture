package com.veldan.mycleanarchitecture.presentation.fragments.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.veldan.mycleanarchitecture.databinding.FragmentStartBinding
import com.veldan.mycleanarchitecture.framework.ROOT_ViewModelFactory

class StartFragment : Fragment() {

    // Binding
    private lateinit var binding: FragmentStartBinding

    // ViewModel
    private lateinit var viewModel: StartViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        initViewModel()
        initBinding()

        return binding.root
    }

    // {init}: ViewModel
    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ROOT_ViewModelFactory).get(StartViewModel::class.java)
    }

    // {init}: Binding
    private fun initBinding() {
        binding = FragmentStartBinding.inflate(layoutInflater).apply {
            lifecycleOwner = viewLifecycleOwner
            startViewModel = viewModel
        }
    }
}