package com.veldan.core.interactors

import com.veldan.core.data.repositories.ScoreRepository
import com.veldan.core.domain.Score

class AddScoreUseCase(
    private val scoreRepository: ScoreRepository
) {

    suspend operator fun invoke(score: Score){
        scoreRepository.addScore(score)
    }

}