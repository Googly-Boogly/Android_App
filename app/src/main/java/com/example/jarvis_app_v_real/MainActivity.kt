package com.example.jarvis_app_v_real

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.example.jarvis_app_v_real.database_objects.AppDatabase
import com.example.jarvis_app_v_real.database_objects.Tasks
import com.example.jarvis_app_v_real.databinding.ActivityMainBinding
import com.example.jarvis_app_v_real.websocket_connection.AudioWebSocketManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Needs to be called to be able to send notifications
        createNotificationChannel()

//        Screen Stuff
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,
                R.id.navigation_light, R.id.navigation_graph, R.id.navigation_pw
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        End Screen Stuff

//        Database Example
//        Best practice is to do this on the async thread
//        Trying to finish this quickly so gonna do it the cheating way (this way)
        val appDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "your-database-name"
        ).build()

        coroutineScope.launch {
            val idk: List<Tasks> = withContext(Dispatchers.IO) {
                appDatabase.tasksDao().getAll()
            }
        withContext(Dispatchers.Main) {
            println(idk)
        }}
//        End Database Example
        // Initialize AudioWebSocketManager
        AudioWebSocketManager.initialize(lifecycleScope)


    }

    override fun onDestroy() {
        super.onDestroy()
        // Stop AudioWebSocketManager when the activity is destroyed
        AudioWebSocketManager.stop()
    }
    private fun createNotificationChannel() {
        /**
         * creates the notification channel
         * safe to call multiple times
         * @return NA
         */
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is not in the Support Library.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.hello_blank_fragment)
            val descriptionText = getString(R.string.notification_desc)
            val importance = NotificationManager.IMPORTANCE_HIGH
            val cHANNEL_ID = "jarvis_app_notifications"
            val channel = NotificationChannel(cHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system.
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
    fun createNotification(contentTitle: String, contentText: String,
                                   toNotify: Boolean = true): NotificationCompat.Builder {
        /**
         * Creates a notification and notifies if specified.
         *
         * @param:contentTitle The title of the notification.
         * @param:contentText The text of the notification.
         * @param:toNotify If true, the notification will be shown; otherwise, it won't.
         * @return An object representing the created notification.
         */
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager
        val CHANNEL_ID = "jarvis_app_notifications"

        // Notification content

//        val intent = Intent(this, YourActivity::class.java)
//
//        val pendingIntent = PendingIntent.getActivity(
//            this,
//            0,
//            intent,
//            PendingIntent.FLAG_UPDATE_CURRENT
//        )

        // Build the notification
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_home_black_24dp)
            .setContentTitle(contentTitle)
            .setContentText(contentText)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
//            .setContentIntent(pendingIntent)
            .setAutoCancel(false)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)

        // Notify
        if (toNotify) {
            notificationManager.notify(/*Notification ID*/ 1, builder.build())
        }
        return builder
    }

}


