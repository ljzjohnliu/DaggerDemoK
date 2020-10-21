package com.ljz.daggerk.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ljz.daggerk.MyApp
import com.ljz.daggerk.R
import com.ljz.daggerk.basicuse.Cat
import com.ljz.daggerk.basicuse.DaggerMainComponent
import com.ljz.daggerk.qualifieruse.Flower
import com.ljz.daggerk.qualifieruse.MainModule
import com.ljz.daggerk.qualifieruse.QualifierBlue
import com.ljz.daggerk.singletonuse.Book
import com.ljz.daggerk.singletonuse.DaggerDetailComponent
import com.ljz.daggerk.singletonuse.DetailModule
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

class DetailActivity : AppCompatActivity() {

    private val TAG: String = "DetailActivity"

    @Inject
    lateinit var book1: Book

    @Inject
    lateinit var book2: Book

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        DaggerDetailComponent.builder()
            .detailModule(DetailModule())
            /**
             * commonComponent()方法需要一个 CommonComponent 对象，同理在 ShareActivity 中也需要一个 CommonComponent 对象，这里我们要保证两个 CommonComponent 对象是同一个
             **/
            .commonComponent((getApplication() as MyApp).getCommonComponent())
            .build()
            .inject(this)

        Log.d(TAG, "onCreate, book1 : " + book1.toString())
        Log.d(TAG, "onCreate, book2 : " + book2.toString())
    }
}