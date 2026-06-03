package org.ropotov.dailyharmony.habits.model

data class HabitUi(
    val id: String,
    val title: String,
    val description: String,
    val progressDays: Int,
    val isDoneToday: Boolean
)