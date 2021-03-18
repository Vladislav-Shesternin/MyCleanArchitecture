package com.veldan.mycleanarchitecture.framework

import com.veldan.core.interactors.AddScoreUseCase
import com.veldan.core.interactors.DeleteScoreUseCase
import com.veldan.core.interactors.ReadAllScoresUseCase

data class Interactors(
    private val addScore: AddScoreUseCase,
    private val deleteScore: DeleteScoreUseCase,
    private val readAllScores: ReadAllScoresUseCase,
)