package com.example.firstkotlinpractice.di

import android.content.Context
import android.media.Image
import com.example.firstkotlinpractice.data.repositories.ImageRepository
import com.example.firstkotlinpractice.data.repositories.RandomUserRepository
import com.example.firstkotlinpractice.data.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserRepository(@ApplicationContext context: Context): UserRepository {
        return UserRepository(context)
    }

    @Provides
    @Singleton
    fun provideImageRepository(): ImageRepository {
        return ImageRepository()
    }

    @Provides
    @Singleton
    fun provideRandomUserRepository(): RandomUserRepository {
        return RandomUserRepository()
    }

}