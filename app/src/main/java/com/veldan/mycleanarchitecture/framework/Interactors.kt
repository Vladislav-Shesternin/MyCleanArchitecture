package com.veldan.mycleanarchitecture.framework

import com.veldan.core.interactors.AddScoreUseCase
import com.veldan.core.interactors.DeleteScoreUseCase
import com.veldan.core.interactors.ReadAllScoresUseCase

data class Interactors(
    val addScore: AddScoreUseCase,
    val deleteScore: DeleteScoreUseCase,
    val readAllScores: ReadAllScoresUseCase,
)