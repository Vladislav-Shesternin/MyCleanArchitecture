package com.veldan.mycleanarchitecture.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class ROOT_ViewModel(
    application: Application,
    interactors: Interactors
) : AndroidViewModel(application)