package com.ljz.daggerk.basicuse

import com.ljz.daggerk.activity.MainActivity
import com.ljz.daggerk.qualifieruse.MainModule
import dagger.Component

@Component(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}