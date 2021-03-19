package com.veldan.mycleanarchitecture.framework.data_sources.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.veldan.mycleanarchitecture.framework.data_sources.room.entities.ScoreEntity

@Dao
interface ScoreDao {

    @Insert
    suspend fun insert(score: ScoreEntity)

    @Query("SELECT * FROM score_table")
    suspend fun readAll(): List<ScoreEntity>

    @Query("DELETE FROM score_table WHERE score = :score")
    suspend fun delete(score: Int)

}