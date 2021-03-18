package com.veldan.mycleanarchitecture.framework.data_sources

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.veldan.core.domain.Score

@Dao
interface ScoreDao {

    @Insert
    suspend fun insert(score: ScoreEntity)

    @Query("SELECT * FROM score_table")
    suspend fun readAll(): List<ScoreEntity>

    @Delete
    suspend fun delete(score: ScoreEntity)

}