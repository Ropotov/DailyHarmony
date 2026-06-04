package org.ropotov.dailyharmony.database

import androidx.room.RoomDatabase

interface DatabaseFactory {
    fun createDatabase(): RoomDatabase.Builder<HabitDatabase>
}