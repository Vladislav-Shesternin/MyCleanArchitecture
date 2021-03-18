package com.veldan.mycleanarchitecture.presentation.fragments.start

import android.util.Log
import com.veldan.mycleanarchitecture.framework.Interactors
import com.veldan.mycleanarchitecture.framework.MyViewModel

class StartViewModel(
    interactors: Interactors
) : MyViewModel(interactors) {
    init {
        Log.i("VLAD", "StartViewModel")
    }
}