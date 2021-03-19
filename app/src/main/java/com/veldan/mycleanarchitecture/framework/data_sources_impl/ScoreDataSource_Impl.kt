package com.veldan.mycleanarchitecture.framework.data_sources_impl

import android.content.Context
import com.veldan.core.data.sources.ScoreDataSource
import com.veldan.core.domain.Score
import com.veldan.mycleanarchitecture.framework.data_sources.room.MyRoomDatabase
import com.veldan.mycleanarchitecture.framework.data_sources.room.entities.*

class ScoreDataSource_Impl(
    context: Context
) : ScoreDataSource {

    private val scoreDao = MyRoomDatabase.getInstance(context).scoreDao

    override suspend fun add(score: Score) {
        val scoreEntity = ScoreEntityConvertors.convertScoreToScoreEntity(score)
        scoreDao.insert(scoreEntity)
    }

    override suspend fun readAll(): List<Score> {
        return scoreDao.readAll().asScoreList()
    }

    override suspend fun delete(score: Int) {
        scoreDao.delete(score)
    }
}