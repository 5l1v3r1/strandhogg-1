package com.example.nativeactivity

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class BackgroundServices : Service() {
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Service started by user.", Toast.LENGTH_LONG).show()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Service destroyed by user.", Toast.LENGTH_LONG).show()
    }
}