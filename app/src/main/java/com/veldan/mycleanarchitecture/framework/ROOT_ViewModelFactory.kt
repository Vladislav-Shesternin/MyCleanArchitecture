package com.veldan.mycleanarchitecture.framework

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object ROOT_ViewModelFactory : ViewModelProvider.Factory {

    private val ParentViewModel = ROOT_ViewModel::class.java

    private lateinit var application: Application
    private lateinit var interactors: Interactors

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (ParentViewModel.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(
                Application::class.java,
                Interactors::class.java
            ).newInstance(
                application,
                interactors
            )
        }
        throw IllegalArgumentException("ViewModel must extend ${ParentViewModel.simpleName}")
    }

    fun inject(
        application: Application,
        interactors: Interactors
    ) {
        this.application = application
        this.interactors = interactors
    }
}
