package com.example.jarvis_app_v_real.global_code

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.example.jarvis_app_v_real.R
import android.app.NotificationChannel

import android.app.PendingIntent

import android.content.Intent
import android.os.Build
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.jarvis_app_v_real.databinding.ActivityMainBinding
import com.example.jarvis_app_v_real.websocket_connection.AudioWebSocketManager


//class assets {
//    private fun createNotification(contentTitle: String, contentText: String,
//                                   toNotify: Boolean = true): NotificationCompat.Builder {
//        /**
//         * Creates a notification and notifies if specified.
//         *
//         * @param contentTitle The title of the notification.
//         * @param contentText The text of the notification.
//         * @param toNotify If true, the notification will be shown; otherwise, it won't.
//         * @return An object representing the created notification.
//         */
//        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)
//                as NotificationManager
//        val CHANNEL_ID = "jarvis_app_notifications"
//
//        // Notification content
//
////        val intent = Intent(this, YourActivity::class.java)
////
////        val pendingIntent = PendingIntent.getActivity(
////            this,
////            0,
////            intent,
////            PendingIntent.FLAG_UPDATE_CURRENT
////        )
//
//        // Build the notification
//        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
//            .setSmallIcon(R.drawable.ic_home_black_24dp) // Replace with your notification icon
//            .setContentTitle(contentTitle)
//            .setContentText(contentText)
//            .setPriority(NotificationCompat.PRIORITY_HIGH)
////            .setContentIntent(pendingIntent)
//            .setAutoCancel(true) // Automatically dismiss the notification when the user taps it
//
//        // Notify
//        if (toNotify) {
//            println("NOTIFIED")
//            notificationManager.notify(/*Notification ID*/ 1, builder.build())
//        }
//        return builder
//    }
//}