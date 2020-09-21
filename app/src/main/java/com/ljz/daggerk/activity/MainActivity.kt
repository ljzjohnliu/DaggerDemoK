package com.ljz.daggerk.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ljz.daggerk.R
import com.ljz.daggerk.basicuse.Cat
import com.ljz.daggerk.basicuse.DaggerMainComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"

    @Inject
    lateinit var cat: Cat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainComponent.builder()
                .build()
                .inject(this)

        Log.d(TAG, "onCreate, cat : " + cat.toString())
    }
}