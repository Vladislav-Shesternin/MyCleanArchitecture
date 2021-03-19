package com.veldan.core.data.sources

import com.veldan.core.domain.Score

interface ScoreDataSource {

    suspend fun add(score: Score)

    suspend fun readAll(): List<Score>

    suspend fun delete(score: Int)

}