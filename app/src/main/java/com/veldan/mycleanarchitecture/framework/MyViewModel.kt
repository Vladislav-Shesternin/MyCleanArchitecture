package com.veldan.mycleanarchitecture.framework

import android.util.Log
import androidx.lifecycle.ViewModel

open class MyViewModel(
    protected val interactors: Interactors
) : ViewModel() {
    init {
        Log.i("VLAD", "MyViewModel")
    }
}