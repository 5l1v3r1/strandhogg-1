package com.example.nativeactivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()
        println("1a1a1a1a1:"+stringFromJNI())

        startActivity(Intent(this, Screen2::class.java))

    }

    external fun stringFromJNI(): String
    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

    override fun onPause() {
        super.onPause()
        println("1q1q1q1q11q");
        foregroundService(1)
    }

    override fun onDestroy() {
        super.onDestroy()
        println("2q2q2q2q");
        foregroundService(1)
        println("3q3q3qqq3");
        onStart()
        println("4we4e444e4e")
    }

    override fun onStart() {
        super.onStart()
        println("5q5q5q5q5")
        setContentView(R.layout.activity_main)
    }

    private fun foregroundService(a : Int){
        if(a == 1){
            ForegroundService.startService(this, "Foreground Service is running...")
            startService(Intent(this@MainActivity, BackgroundServices::class.java))
        }else if(a == 2){
            ForegroundService.stopService(this)
            stopService(Intent(this@MainActivity, BackgroundServices::class.java))
        }
    }
}
