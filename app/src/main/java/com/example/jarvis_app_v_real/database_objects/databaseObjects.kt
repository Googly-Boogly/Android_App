package com.example.jarvis_app_v_real.database_objects

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}

@Dao
interface TasksDao {
    @Query("SELECT * FROM Tasks")
    fun getAll(): List<Tasks>

    @Query("SELECT * FROM Tasks WHERE uid IN (:taskIds)")
    fun loadAllByIds(taskIds: IntArray): List<Tasks>

//    @Query("SELECT * FROM Tasks WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): User

    @Insert
    fun insertAll(vararg task: Tasks)

    @Delete
    fun delete(task: Tasks)
}

@Dao
interface HabitDao {
    @Query("SELECT * FROM Habit")
    fun getAll(): List<Habit>

    @Query("SELECT * FROM Habit WHERE habitId IN (:habitId)")
    fun loadAllByIds(habitId: IntArray): List<Habit>

    @Insert
    fun insertAll(vararg habit: Habit)

    @Delete
    fun delete(habit: Habit)
}

@Dao
interface CompletedHabitsDao {
    @Query("SELECT * FROM CompletedHabits")
    fun getAll(): List<Tasks>

    @Query("SELECT * FROM CompletedHabits WHERE uid IN (:completedHabitId)")
    fun loadAllByIds(completedHabitId: IntArray): List<CompletedHabits>

    @Insert
    fun insertAll(vararg habit: CompletedHabits)

    @Delete
    fun delete(habit: CompletedHabits)
}

@Dao
interface RemindersDao {
    @Query("SELECT * FROM Reminders")
    fun getAll(): List<Reminders>

    @Query("SELECT * FROM Reminders WHERE uid IN (:remindersId)")
    fun loadAllByIds(remindersId: IntArray): List<Reminders>

    @Insert
    fun insertAll(vararg reminder: Reminders)

    @Delete
    fun delete(reminder: Reminders)
}

@Dao
interface NoteDao {
    @Query("SELECT * FROM Note")
    fun getAll(): List<Note>

    @Query("SELECT * FROM Note WHERE noteId IN (:noteIds)")
    fun loadAllByIds(noteIds: IntArray): List<Note>

    @Insert
    fun insertAll(vararg note: Note)

    @Delete
    fun delete(note: Note)
}

@Dao
interface NoteFileDao {
    @Query("SELECT * FROM NoteFile")
    fun getAll(): List<NoteFile>

    @Query("SELECT * FROM NoteFile WHERE uid IN (:noteFileIds)")
    fun loadAllByIds(noteFileIds: IntArray): List<NoteFile>

    @Insert
    fun insertAll(vararg noteFile: NoteFile)

    @Delete
    fun delete(noteFile: NoteFile)
}

@Dao
interface NotificationDao {
    @Query("SELECT * FROM Notification")
    fun getAll(): List<Notification>

    @Query("SELECT * FROM Notification WHERE notificationId IN (:notificationIds)")
    fun loadAllByIds(notificationIds: IntArray): List<Notification>

    @Insert
    fun insertAll(vararg notification: Notification)

    @Delete
    fun delete(notification: Notification)
}