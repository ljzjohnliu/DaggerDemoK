package com.ljz.daggerk.common

import com.ljz.daggerk.singletonuse.Book
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CommonModule {

    @Singleton
    @Provides
    fun provideBook() : Book {
        return Book("Flutter 指南", 68.8f)
    }
}