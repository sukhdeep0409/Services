package com.example.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_service.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                service_info.text = "Service Running"
            }
        }

        stop_service.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                service_info.text = "Service Stopped"
            }
        }

        send_data.setOnClickListener {
            Intent(this, MyService::class.java).also {
                val dataString = data.text.toString()
                it.putExtra("EXTRA_DATA", dataString)
                startService(it)
            }
        }
    }
}