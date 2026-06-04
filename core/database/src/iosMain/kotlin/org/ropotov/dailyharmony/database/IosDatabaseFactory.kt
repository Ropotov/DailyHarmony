package org.ropotov.dailyharmony.database

import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSApplicationSupportDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

class IosDatabaseFactory : DatabaseFactory {

    override fun createDatabase(): RoomDatabase.Builder<HabitDatabase> {
        val dbPath = documentDirectory() + "/daily_harmony.db"

        return Room.databaseBuilder<HabitDatabase>(
            name = dbPath
        ).fallbackToDestructiveMigration(false)

    }

    @OptIn(ExperimentalForeignApi::class)
    private fun documentDirectory(): String {
        val url: NSURL = NSFileManager.defaultManager.URLForDirectory(
            directory = NSApplicationSupportDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = true,
            error = null
        ) ?: error("Cannot resolve Application Support directory")

        return requireNotNull(url.path) { "Application Support path is null" }
    }
}