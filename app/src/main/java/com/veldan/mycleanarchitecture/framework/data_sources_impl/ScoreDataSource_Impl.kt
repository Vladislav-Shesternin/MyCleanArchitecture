package com.veldan.mycleanarchitecture.framework.data_sources_impl

import android.content.Context
import com.veldan.core.data.sources.ScoreDataSource
import com.veldan.core.domain.Score
import com.veldan.mycleanarchitecture.framework.data_sources.room.MyRoomDatabase
import com.veldan.mycleanarchitecture.framework.data_sources.room.entities.ScoreEntity
import com.veldan.mycleanarchitecture.framework.data_sources.room.entities.asScoreList
import com.veldan.mycleanarchitecture.framework.data_sources.room.entities.fillFrom

class ScoreDataSource_Impl(
    context: Context
) : ScoreDataSource {

    private val scoreDao = MyRoomDatabase.getInstance(context).scoreDao

    override suspend fun add(score: Score) {
        val scoreEntity = ScoreEntity() fillFrom score
        scoreDao.insert(scoreEntity)
    }

    override suspend fun readAll(): List<Score> {
        return scoreDao.readAll().asScoreList()
    }

    override suspend fun delete(score: Score) {
        val scoreEntity = ScoreEntity() fillFrom score
        scoreDao.delete(scoreEntity)
    }
}