package com.ljz.daggerk.basicuse

import com.ljz.daggerk.activity.MainActivity
import com.ljz.daggerk.common.CommonComponent
import com.ljz.daggerk.common.CommonScope
import com.ljz.daggerk.qualifieruse.MainModule
import dagger.Component

@CommonScope
@Component(modules = arrayOf(MainModule::class), dependencies = [CommonComponent::class])
interface MainComponent {
    fun inject(activity: MainActivity)
}