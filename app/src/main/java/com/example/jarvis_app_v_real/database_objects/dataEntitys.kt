package com.example.jarvis_app_v_real.database_objects

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation


@Entity
data class User(
    // Testing Entity
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
)

@Entity
data class Tasks(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "task_name") val taskName: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "due_date") val dueDate: String?,
    @ColumnInfo(name = "priority") val priority: String?,
    @ColumnInfo(name = "status") val status: String?,
    @ColumnInfo(name = "added") val added: String?,
    @ColumnInfo(name = "updated") val updated: String?,
)

@Entity
data class Habit(
    @PrimaryKey val habitId: Int,
    @ColumnInfo(name = "name") val taskName: String?,
    @ColumnInfo(name = "due_time") val dueTime: String?,
    @ColumnInfo(name = "done_for_day") val doneForDay: Boolean?,
    @ColumnInfo(name = "priority") val priority: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "added") val added: String?,
    @ColumnInfo(name = "updated") val updated: String?,
    @ColumnInfo(name = "repeat_days") val repeatDays: String?,
    @ColumnInfo(name = "reminded") val reminded: Boolean?
)


@Entity
data class CompletedHabits(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "habit_id") val habitId: Int,
    @ColumnInfo(name = "added") val added: String?,
    @ColumnInfo(name = "updated") val updated: String?
)

data class HabitsAndCompletedHabits(
    @Embedded val habit: Habit,
    @Relation(
        parentColumn = "habitId",
        entityColumn = "habit_id"
    )
    val completedHabits: List<CompletedHabits>
)

@Entity
data class Reminders(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "end_time") val taskName: String?,
    @ColumnInfo(name = "reminder") val dueTime: String?,
    @ColumnInfo(name = "to_say") val doneForDay: Boolean?,
    @ColumnInfo(name = "does_repeat") val priority: Boolean,
    @ColumnInfo(name = "repeat_days") val description: String?,
    @ColumnInfo(name = "added") val added: String?,
    @ColumnInfo(name = "updated") val updated: String?,
    @ColumnInfo(name = "non_repeat_date") val repeatDays: String?,
)

@Entity
data class Note(
    @PrimaryKey val noteId: Int,
    @ColumnInfo(name = "note_text") val noteText: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "note_file_id") val noteFileId: Int?,
    @ColumnInfo(name = "added") val added: String?,
    @ColumnInfo(name = "updated") val updated: String?,
)

@Entity
data class NoteFile(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "note_name") val taskName: String?,
    @ColumnInfo(name = "added") val added: String?,
    @ColumnInfo(name = "updated") val updated: String?,
)

data class NoteFileAndNotes(
    @Embedded val habit: Habit,
    @Relation(
        parentColumn = "note_file_id",
        entityColumn = "noteFileId"
    )
    val allNotes: List<Note>
)

@Entity
data class Notification(
    @PrimaryKey val notificationId: Int,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "description_short") val descriptionShort: String?,
    @ColumnInfo(name = "description_long") val descriptionLong: String?,
    @ColumnInfo(name = "datetime_to_go_off") val datetimeToGoOff: String?,
    @ColumnInfo(name = "added") val added: String?,
    @ColumnInfo(name = "updated") val updated: String?,

)