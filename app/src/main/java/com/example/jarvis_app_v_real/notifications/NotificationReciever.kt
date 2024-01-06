package com.example.jarvis_app_v_real.notifications

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.jarvis_app_v_real.R

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // Handle the notification here
        showNotification(context, "Your Title", "Your Content")
    }
//
    @SuppressLint("MissingPermission")
    private fun showNotification(context: Context, title: String, content: String) {
        val notificationBuilder = NotificationCompat.Builder(context, "jarvis_app_notifications")
//            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(title)
            .setContentText(content)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(context)) {
//            notify(NOTIFICATION_ID, notificationBuilder.build())
        }
    }
}
