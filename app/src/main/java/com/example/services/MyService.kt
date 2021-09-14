package com.example.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    private val TAG = "MyService"

    init {
        Log.i(TAG, "service is running ... ")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("EXTRA_DATA")
        dataString?.let {
            Log.i(TAG ,it)
        }

        return START_STICKY
    }

    /**
     * START_NOT_STICKY : If the system kills the service it will not recreate
     * START_STICKY : If the system kills the service it will recreate it and the last intent passed to it will be null
     * START_REDELIVERED : If the system kills the service it will recreate it and the last intent passed to it will remain same
     */
}