package com.veldan.mycleanarchitecture.presentation.fragments.start

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.veldan.core.domain.Score
import com.veldan.mycleanarchitecture.framework.Interactors
import com.veldan.mycleanarchitecture.framework.ROOT_ViewModel
import kotlinx.coroutines.launch

class StartViewModel(
    application: Application,
    private val interactors: Interactors
) : ROOT_ViewModel(
    application,
    interactors
) {

    private var score = 0
    private val _increment = MutableLiveData(0)
    val increment: LiveData<Int>
        get() = _increment

    val scoreAmount = MediatorLiveData<Int>().apply {
        addSource(increment) {
            this.value = it
        }
    }

    // ------------------------------------------------------------| Start Initialization |
    init {
        viewModelScope.launch {
            readAllScores().size.also {
                _increment.postValue(it)
                score = it
            }
        }
    }

    // ------------------------------------------------------------| suspend fun - Room ScoreEntity |
    private suspend fun readAllScores(): List<Score> {
        return interactors.readAllScores()
    }

    // ------------------------------------------------------------| fun - Room ScoreEntity |
    fun addScore() {
        _increment.value = ++score

        viewModelScope.launch {
            interactors.addScore(Score(increment.value!!))
        }
    }


    fun deleteScore() {
        viewModelScope.launch {
            if (score > 0) interactors.deleteScore(increment.value!!)
        }

        _increment.value = if (score > 0) --score else return
    }
}