package org.ropotov.dailyharmony.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

class AndroidDatabaseFactory(
    private val context: Context
) : DatabaseFactory {
    override fun createDatabase(): RoomDatabase.Builder<HabitDatabase> {
        val dbFile = context.getDatabasePath("habits.db").absolutePath

        return Room.databaseBuilder<HabitDatabase>(
            context = context.applicationContext,
            name = dbFile
        ).fallbackToDestructiveMigration(false)
    }
}