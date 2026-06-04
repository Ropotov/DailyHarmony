package org.ropotov.dailyharmony.database

import android.content.Context
import androidx.room.RoomDatabase
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class AndroidHabitDatabaseModule {

    @Single
    fun provideHabitDatabase(
        context: Context
    ): RoomDatabase.Builder<HabitDatabase> {
        return AndroidDatabaseFactory(context).createDatabase()
    }
}