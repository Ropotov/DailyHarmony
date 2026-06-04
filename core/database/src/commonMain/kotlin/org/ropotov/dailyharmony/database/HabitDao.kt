package org.ropotov.dailyharmony.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.ropotov.dailyharmony.database.model.HabitEntity

@Dao
interface HabitDao {

    @Query("SELECT * FROM habits")
    fun observeHabits(): Flow<List<HabitEntity>>

    @Query("SELECT * FROM habits WHERE id = :id LIMIT 1")
    suspend fun getHabitById(id: String): HabitEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertHabit(habit: HabitEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertHabits(habits: List<HabitEntity>)

    @Query("DELETE FROM habits WHERE id = :id")
    suspend fun deleteHabit(id: String)

    @Query("UPDATE habits SET isDoneToday = 1, progressDays = progressDays + 1 WHERE id = :id AND isDoneToday = 0")
    suspend fun markDoneToday(id: String)

    @Query("UPDATE habits SET isDoneToday = 0 WHERE id = :id")
    suspend fun resetToday(id: String)
}