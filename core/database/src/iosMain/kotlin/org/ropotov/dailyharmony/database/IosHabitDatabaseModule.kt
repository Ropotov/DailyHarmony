package org.ropotov.dailyharmony.database

import androidx.room.RoomDatabase
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class IosHabitDatabaseModule {

    @Single
    fun provideHabitDatabase(): RoomDatabase.Builder<HabitDatabase> {
        return IosDatabaseFactory().createDatabase()
    }
}