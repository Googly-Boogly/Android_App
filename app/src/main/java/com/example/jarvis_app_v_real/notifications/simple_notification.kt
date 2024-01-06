package com.example.jarvis_app_v_real.notifications

import android.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat


//class NotificationHelper(private val context: Context) {
//    var builder = NotificationCompat.Builder(this, CHANNEL_ID)
//        .setSmallIcon(R.drawable.notification_icon)
//        .setContentTitle(textTitle)
//        .setContentText(textContent)
//        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//    private val channelId = "my_channel"
//    private val notificationId = 1
//
//    init {
//        createNotificationChannel()
//    }
//
//    private fun createNotificationChannel() {
//        // Create the NotificationChannel, but only on API 26+ because the NotificationChannel class is new and not in the support library
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val name = "My Channel"
//            val descriptionText = "My Channel Description"
//            val importance = NotificationManager.IMPORTANCE_DEFAULT
//            val channel = NotificationChannel(channelId, name, importance).apply {
//                description = descriptionText
//            }
//
//            // Register the channel with the system
//            val notificationManager: NotificationManager =
//                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//            notificationManager.createNotificationChannel(channel)
//        }
//    }
//
//    fun showNotification(title: String, content: String) {
//        val builder = NotificationCompat.Builder(context, channelId)
//            .setSmallIcon(R.drawable.ic_dialog_info)
//            .setContentTitle(title)
//            .setContentText(content)
//            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//
//        with(NotificationManagerCompat.from(context)) {
//            // notificationId is a unique int for each notification that you must define
//            notify(notificationId, builder.build())
//        }
//    }
//}
//
//fun main() {
//    simple_notification()
//}