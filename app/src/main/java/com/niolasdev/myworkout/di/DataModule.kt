package com.niolasdev.myworkout.di

import android.content.Context
import com.niolasdev.myworkout.domain.WorkoutRepositoryImpl
import com.niolasdev.myworkout.domain.WorkoutRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json {
            ignoreUnknownKeys = true
            explicitNulls = false
        }
    }

    @Provides
    @Singleton
    fun provideWorkoutRepository(
        json: Json,
        @ApplicationContext context: Context,
    ): WorkoutRepository {
        return WorkoutRepositoryImpl(json, context)
    }
}