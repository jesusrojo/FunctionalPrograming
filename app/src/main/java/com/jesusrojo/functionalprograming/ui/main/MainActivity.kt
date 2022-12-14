package com.jesusrojo.functionalprograming.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jesusrojo.functionalprograming.R

class MainActivity : AppCompatActivity() {

    //add on web
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}
