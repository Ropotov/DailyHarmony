package org.ropotov.dailyharmony.habits.model

import org.ropotov.dailyharmony.database.model.HabitEntity

data class HabitUi(
    val id: String,
    val title: String,
    val description: String,
    val progressDays: Int,
    val isDoneToday: Boolean
)

fun HabitEntity.toUi(): HabitUi = HabitUi(
    id = id,
    title = title,
    description = description,
    progressDays = progressDays,
    isDoneToday = isDoneToday
)

fun HabitUi.toEntity(): HabitEntity = HabitEntity(
    id = id,
    title = title,
    description = description,
    progressDays = progressDays,
    isDoneToday = isDoneToday
)