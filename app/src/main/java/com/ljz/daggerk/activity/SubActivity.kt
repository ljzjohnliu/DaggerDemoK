package com.ljz.daggerk.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ljz.daggerk.MyApp
import com.ljz.daggerk.R
import com.ljz.daggerk.qualifieruse.Flower
import com.ljz.daggerk.singletonuse.Book
import com.ljz.daggerk.singletonuse.DaggerDetailComponent
import com.ljz.daggerk.singletonuse.DetailModule
import com.ljz.daggerk.subcompuse.SubModule
import javax.inject.Inject

class SubActivity : AppCompatActivity() {
    private val TAG: String = "SubActivity"

    @Inject
    lateinit var book: Book

    @Inject
    lateinit var flower: Flower

    fun start(context: Context) {
        context.startActivity(Intent(context, SubActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        var detailComponent = DaggerDetailComponent.builder()
            .detailModule(DetailModule())
            .commonComponent((application as MyApp).getCommonComponent())
            .build()

        detailComponent.getSubComponent(SubModule()).inject(this)

        Log.d(TAG, "onCreate, book : $book")
        Log.d(TAG, "onCreate, flower : $flower")
    }
}