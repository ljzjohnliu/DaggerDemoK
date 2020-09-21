package com.ljz.daggerk.qualifieruse

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MainModule {

    @Named("red")
    @Provides
    open fun providesRedRose(): Flower {
        return Flower("玫瑰", "红色")
    }

    @Named("white")
    @Provides
    open fun provideWhiteRose(): Flower {
        return Flower("玫瑰", "白色")
    }

    @QualifierBlue
    @Provides
    open fun provideBlueRose(): Flower{
        return Flower("玫瑰", "蓝色")
    }
}