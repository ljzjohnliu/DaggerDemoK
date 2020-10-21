package com.ljz.daggerk

import android.app.Application
import com.ljz.daggerk.common.CommonComponent
import com.ljz.daggerk.common.CommonModule
import com.ljz.daggerk.common.DaggerCommonComponent

class MyApp : Application() {

    private var commonComponent: CommonComponent? = null

    override fun onCreate() {
        super.onCreate()
        commonComponent = DaggerCommonComponent.builder().commonModule(CommonModule()).build()
    }

    fun getCommonComponent(): CommonComponent? {
        return commonComponent
    }
}