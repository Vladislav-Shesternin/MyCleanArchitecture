package com.veldan.mycleanarchitecture.framework.data_sources

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.veldan.core.domain.Score

@Entity(tableName = "score_table")
class ScoreEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "score")
    var score: Int = 0

)

// ------------------------------------------------------------| [Convertors] extension functions |
// {infix ext fun}: .fillFrom
infix fun ScoreEntity.fillFrom(score: Score): ScoreEntity {
    return this.also {
        it.score = score.score
    }
}

// {ext fun}: .asScoreList
fun List<ScoreEntity>.asScoreList(): List<Score> {
    return this.map {
        Score(
            score = it.score
        )
    }
}