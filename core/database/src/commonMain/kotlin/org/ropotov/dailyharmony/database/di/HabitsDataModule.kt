package org.ropotov.dailyharmony.database.di

import androidx.room.RoomDatabase
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.ropotov.dailyharmony.database.HabitDao
import org.ropotov.dailyharmony.database.HabitDatabase
import org.ropotov.dailyharmony.database.HabitsRepository
import org.ropotov.dailyharmony.database.getRoomDatabase

@Module
class HabitsDataModule {

    @Single
    fun provideHabitDao(
        databaseBuilder: RoomDatabase.Builder<HabitDatabase>
    ): HabitDatabase = getRoomDatabase(databaseBuilder)

    fun provideHabitDao(
        database: HabitDatabase
    ): HabitDao = database.habitDao()

    @Single
    fun provideHabitRepository(
        habitDao: HabitDao
    ): HabitsRepository = HabitsRepository(habitDao)

}