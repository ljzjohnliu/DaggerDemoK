package com.ljz.daggerk.activity

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ljz.daggerk.R
import com.ljz.daggerk.basicuse.Cat
import com.ljz.daggerk.basicuse.DaggerMainComponent
import com.ljz.daggerk.qualifieruse.Flower
import com.ljz.daggerk.qualifieruse.MainModule
import com.ljz.daggerk.qualifieruse.QualifierBlue
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG: String = "MainActivity"

    lateinit var mContext: Context

    @Inject
    lateinit var cat: Cat

    @Named("red")
    @Inject
    lateinit var flower1: Flower

    @Named("white")
    @Inject
    lateinit var flower2: Flower

    @QualifierBlue
    @Inject
    lateinit var flower3: Flower

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this
        findViewById<View>(R.id.to_detail).setOnClickListener(this)

        DaggerMainComponent.builder()
            .mainModule(MainModule())//这一行不写也是OK的，看下 DaggerMainComponent 实现就清楚了
            .build()
            .inject(this)

        Log.d(TAG, "onCreate, cat : " + cat.toString())
        Log.d(TAG, "onCreate, flower1 : " + flower1.toString())
        Log.d(TAG, "onCreate, flower2 : " + flower2.toString())
        Log.d(TAG, "onCreate, flower3 : " + flower3.toString())
    }

    override fun onClick(v: View?) {
        val id = v!!.id
        val intent = Intent()
        when (id) {
            R.id.to_detail -> intent.component =
                ComponentName("com.ljz.daggerk", "com.ljz.daggerk.activity.DetailActivity")
            else -> {
                Toast.makeText(mContext, "没有有效的跳转页面", Toast.LENGTH_SHORT).show()
                return
            }
        }
        startActivity(intent)
    }
}