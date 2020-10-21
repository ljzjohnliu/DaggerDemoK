package com.ljz.daggerk.subcompuse

import com.ljz.daggerk.activity.SubActivity
import dagger.Subcomponent

@Subcomponent(modules = [SubModule::class])
interface MySubComponent {
    fun inject(activity: SubActivity)
}