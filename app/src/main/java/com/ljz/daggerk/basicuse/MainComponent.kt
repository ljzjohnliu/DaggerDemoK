package com.ljz.daggerk.basicuse

import com.ljz.daggerk.activity.MainActivity
import dagger.Component

@Component
interface MainComponent {
    fun inject(activity: MainActivity)
}