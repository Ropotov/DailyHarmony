package org.ropotov.dailyharmony.database

import kotlinx.coroutines.flow.Flow
import org.ropotov.dailyharmony.database.model.HabitEntity
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class HabitsRepository(private val habitDao: HabitDao) {

    fun observeHabits(): Flow<List<HabitEntity>> = habitDao.observeHabits()

    @OptIn(ExperimentalUuidApi::class)
    suspend fun addHabit(
        title: String,
        description: String
    ) {
        habitDao.upsertHabit(
            HabitEntity(
                id = Uuid.random().toString(),
                title = title,
                description = description,
                progressDays = 0,
                isDoneToday = false
            )
        )
    }

    suspend fun markDoneToday(id: String) {
        habitDao.markDoneToday(id)
    }

    suspend fun deleteHabit(id: String) {
        habitDao.deleteHabit(id)
    }
}