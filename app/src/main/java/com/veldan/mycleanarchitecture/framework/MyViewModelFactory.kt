package com.veldan.mycleanarchitecture.framework

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object MyViewModelFactory : ViewModelProvider.Factory {

    private val ParentViewModel = MyViewModel::class.java

    private lateinit var interactors: Interactors

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        Log.i("VLAD", "viewModel = ${modelClass.simpleName}")
        if (ParentViewModel.isAssignableFrom(modelClass)) {
            Log.i("VLAD", "Factory")
            return modelClass.getConstructor(
                Interactors::class.java
            ).newInstance(
                interactors
            )
        }
        throw IllegalArgumentException("ViewModel must extend ${ParentViewModel.simpleName}")
    }

    fun inject(
        interactors: Interactors
    ) {
        Log.i("VLAD", "Inject")
        this.interactors = interactors
    }
}