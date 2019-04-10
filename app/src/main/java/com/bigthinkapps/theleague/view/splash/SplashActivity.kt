package com.bigthinkapps.theleague.view.splash

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bigthinkapps.theleague.R
import com.bigthinkapps.theleague.extensions.goIntent
import com.bigthinkapps.theleague.utils.AppConstants
import com.bigthinkapps.theleague.view.main.MainActivity

class SplashActivity : AppCompatActivity() {

    private val handler = Handler()
    private val runnable = Runnable {
        goIntent(MainActivity::class.java, true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, AppConstants.DELAY_SPLASH)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }
}
