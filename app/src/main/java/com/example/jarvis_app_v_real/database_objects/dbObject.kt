package com.example.jarvis_app_v_real.database_objects

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Habit::class, CompletedHabits::class, Note::class,
    NoteFile::class, Reminders::class, Tasks::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tasksDao(): TasksDao
    abstract fun habitDao(): HabitDao
    abstract fun completedHabitsDao(): CompletedHabitsDao
    abstract fun remindersDao(): RemindersDao
    abstract fun noteDao(): NoteDao
    abstract fun noteFileDao(): NoteFileDao
    abstract fun notificationDao(): NotificationDao
}
