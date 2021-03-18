package com.veldan.mycleanarchitecture.presentation.fragments.start

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.veldan.mycleanarchitecture.databinding.FragmentStartBinding
import com.veldan.mycleanarchitecture.framework.MyViewModelFactory

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
        Log.i("VLAD", "StartFragment")
        initBinding()
        initViewModel()
        Log.i("VLAD", "StartFragment onCreate")
        return binding.root
    }

    // {init}: Binding
    private fun initBinding() {
        binding = FragmentStartBinding.inflate(layoutInflater)
    }

    // {init}: ViewModel
    private fun initViewModel() {
        Log.i("VLAD", "invoke initViewModel")
        viewModel = ViewModelProvider(this, MyViewModelFactory).get(StartViewModel::class.java)
        Log.i("VLAD", "initViewModel")
    }
}