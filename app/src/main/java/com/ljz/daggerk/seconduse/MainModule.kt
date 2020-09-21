package com.ljz.daggerk.seconduse

import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    open fun providesFlower(): Flower {
        return Flower("玫瑰", "红色")
    }
}