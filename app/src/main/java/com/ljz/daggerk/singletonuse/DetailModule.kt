package com.ljz.daggerk.singletonuse

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DetailModule {

    @Singleton
    @Provides
    fun provideBook(): Book {
        return Book("Kotlin 指南", 66.8f)
    }
}