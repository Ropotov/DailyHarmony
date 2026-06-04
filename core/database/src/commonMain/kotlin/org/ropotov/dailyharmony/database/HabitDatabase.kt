package org.ropotov.dailyharmony.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.ropotov.dailyharmony.database.model.HabitEntity

@Database(
    entities = [HabitEntity::class],
    version = 1,
    exportSchema = true
)
@ConstructedBy(HabitDatabaseConstructor::class)
abstract class HabitDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT", "KotlinNoActualForExpect")
expect object HabitDatabaseConstructor : RoomDatabaseConstructor<HabitDatabase> {
    override fun initialize(): HabitDatabase
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<HabitDatabase>
): HabitDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}