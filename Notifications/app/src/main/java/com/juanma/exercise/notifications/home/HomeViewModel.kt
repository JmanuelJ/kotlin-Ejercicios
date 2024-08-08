package com.juanma.exercise.notifications.home

import android.app.NotificationManager
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModel
import com.juanma.exercise.notifications.NotificationsApp
import com.juanma.exercise.notifications.R

class HomeViewModel: ViewModel() {
    var state by mutableStateOf(HomeState())
    private set

    fun sendNotification(context: Context){
        val notificationManager = context.getSystemService(NotificationManager::class.java)
        val notification = NotificationCompat.Builder(context, NotificationsApp.CHANNEL_ID)
            .setContentTitle(state.name)
            .setContentText("Esto es la descripcion")
            .setSmallIcon(R.drawable.logo_notification)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(state.name.hashCode(), notification)
    }

    fun changeName(text: String){
        state = state.copy(
            name = text
        )
    }

}