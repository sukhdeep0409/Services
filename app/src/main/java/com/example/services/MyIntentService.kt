package com.example.services

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {
    init {
        INSTANCE = this
    }

    companion object {
        private lateinit var INSTANCE: MyIntentService
        var isRunning = false

        fun stopService() {
            Log.d("MyIntentService", "Service is stopping ... ")
            isRunning = false
            INSTANCE.stopSelf()
        }
    }

    override fun onHandleIntent(p0: Intent?) {
        try {
            isRunning = true
            while (isRunning) {
                Log.d("MyIntentService", "Service is running ... ")
            }
        }
        catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}