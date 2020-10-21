package com.ljz.daggerk.singletonuse

import com.ljz.daggerk.activity.DetailActivity
import com.ljz.daggerk.common.CommonComponent
import com.ljz.daggerk.common.CommonScope
import com.ljz.daggerk.subcompuse.MySubComponent
import com.ljz.daggerk.subcompuse.SubModule
import dagger.Component

//@Singleton
@CommonScope
@Component(modules = arrayOf(DetailModule::class), dependencies = [CommonComponent::class])
interface DetailComponent {
    fun inject(activity: DetailActivity)

    fun getSubComponent(module: SubModule): MySubComponent
}