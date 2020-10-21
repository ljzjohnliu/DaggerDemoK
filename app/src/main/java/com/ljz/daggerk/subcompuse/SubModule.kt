package com.ljz.daggerk.subcompuse

import com.ljz.daggerk.qualifieruse.Flower
import dagger.Module
import dagger.Provides

@Module
class SubModule {

    @Provides
    fun provideFlower() : Flower {
        return Flower("腊梅", "红色")
    }
}