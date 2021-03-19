package com.veldan.mycleanarchitecture.framework

import android.app.Application
import com.veldan.core.data.repositories.ScoreRepository
import com.veldan.core.interactors.AddScoreUseCase
import com.veldan.core.interactors.DeleteScoreUseCase
import com.veldan.core.interactors.ReadAllScoresUseCase
import com.veldan.mycleanarchitecture.framework.data_sources_impl.ScoreDataSource_Impl

class ROOT_Application : Application() {

    override fun onCreate() {
        super.onCreate()

        val scoreRepository = ScoreRepository(
            ScoreDataSource_Impl(this)
        )

        ROOT_ViewModelFactory.inject(
            this,
            Interactors(
                AddScoreUseCase(scoreRepository),
                DeleteScoreUseCase(scoreRepository),
                ReadAllScoresUseCase(scoreRepository),
            )
        )
    }
}