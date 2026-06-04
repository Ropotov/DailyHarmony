package org.ropotov.dailyharmony.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habits")
data class HabitEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val progressDays: Int,
    val isDoneToday: Boolean
)