package com.juanma.exercise.notifications

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class NotificationsApp: Application() {

    companion object{
        const val CHANNEL_ID = "my_channel"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT  >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Actualizaciones de profucto",
                NotificationManager.IMPORTANCE_HIGH
            )

            channel.description = "Este canal se usa para notificar actualizaciones del producto"
            val notificationsManager = this.getSystemService(NotificationManager::class.java)
            notificationsManager.createNotificationChannel(channel)

        }
    }

}