package com.ljz.daggerk.singletonuse

import com.ljz.daggerk.activity.DetailActivity
import com.ljz.daggerk.common.CommonComponent
import com.ljz.daggerk.common.CommonModule
import com.ljz.daggerk.common.CommonScope
import dagger.Component
import javax.inject.Singleton

//@Singleton
@CommonScope
@Component(modules = arrayOf(DetailModule::class), dependencies = [CommonComponent::class])
interface DetailComponent {
    fun inject(activity: DetailActivity)
}