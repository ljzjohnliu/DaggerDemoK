package com.ljz.daggerk.singletonuse

import com.ljz.daggerk.activity.DetailActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(DetailModule::class))
interface DetailComponent {
    fun inject(activity: DetailActivity)
}