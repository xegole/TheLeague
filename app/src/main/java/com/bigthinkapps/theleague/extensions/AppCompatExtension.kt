package com.bigthinkapps.theleague.extensions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.goIntent(clazz: Class<*>, isFinish: Boolean) {
    val intent = Intent(this, clazz)
    startActivity(intent)

    if (isFinish) {
        finish()
    }
}