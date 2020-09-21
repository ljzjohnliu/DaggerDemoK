package com.ljz.daggerk.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ljz.daggerk.R
import com.ljz.daggerk.basicuse.Cat
import com.ljz.daggerk.basicuse.DaggerMainComponent
import com.ljz.daggerk.seconduse.Flower
import com.ljz.daggerk.seconduse.MainModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"

    @Inject
    lateinit var cat: Cat

    @Inject
    lateinit var flower: Flower

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainComponent.builder()
            .mainModule(MainModule())//这一行不写也是OK的，看下 DaggerMainComponent 实现就清楚了
                .build()
                .inject(this)

        Log.d(TAG, "onCreate, cat : " + cat.toString())
        Log.d(TAG, "onCreate, flower : " + flower.toString())
    }
}