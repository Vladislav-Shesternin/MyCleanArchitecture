package com.veldan.core.data.repositories

import com.veldan.core.data.sources.ScoreDataSource
import com.veldan.core.domain.Score

class ScoreRepository(
    private val dataSource: ScoreDataSource
) {

    suspend fun addScore(score: Score) {
        dataSource.add(score)
    }

    suspend fun readAllScores(): List<Score> {
        return dataSource.readAll()
    }

    suspend fun delete(score: Score) {
        dataSource.delete(score)
    }
}