package com.veldan.mycleanarchitecture.framework.data_sources.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.veldan.core.domain.Score

@Entity(tableName = "score_table")
data class ScoreEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "score")
    var score: Int

)

// ------------------------------------------------------------| [Convertors] ScoreEntity to Score |
// {ext fun}: .asScoreList
fun List<ScoreEntity>.asScoreList(): List<Score> {
    return this.map {
        Score(
            score = it.score
        )
    }
}

// ------------------------------------------------------------| [Convertors] Score to ScoreEntity |
object ScoreEntityConvertors {
    // {fun}: convertScoreToScoreEntity
    fun convertScoreToScoreEntity(score: Score): ScoreEntity {
        return ScoreEntity(
            score = score.score
        )
    }


}