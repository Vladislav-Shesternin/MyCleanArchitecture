package com.veldan.core.interactors

import com.veldan.core.data.repositories.ScoreRepository
import com.veldan.core.domain.Score

class ReadAllScoresUseCase(
    private val scoreRepository: ScoreRepository
) {

    suspend operator fun invoke(): List<Score> {
        return scoreRepository.readAllScores()
    }

}