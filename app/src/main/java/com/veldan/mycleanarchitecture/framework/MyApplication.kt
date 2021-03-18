package com.veldan.mycleanarchitecture.framework

import android.app.Application
import android.util.Log
import com.veldan.core.data.repositories.ScoreRepository
import com.veldan.core.interactors.AddScoreUseCase
import com.veldan.core.interactors.DeleteScoreUseCase
import com.veldan.core.interactors.ReadAllScoresUseCase
import com.veldan.mycleanarchitecture.framework.data_sources_impl.ScoreDataSource_Impl

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Log.i("VLAD", "Application")
        val scoreRepository = ScoreRepository(
            ScoreDataSource_Impl(this)
        )

        MyViewModelFactory.inject(
            Interactors(
                AddScoreUseCase(scoreRepository),
                DeleteScoreUseCase(scoreRepository),
                ReadAllScoresUseCase(scoreRepository),
            )
        )
    }
}