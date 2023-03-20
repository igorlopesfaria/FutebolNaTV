package br.com.futebolnatv.data.di

import android.content.Context
import android.content.SharedPreferences
import br.com.futebolnatv.commons.constants.Constants
import br.com.futebolnatv.data.onboarding.datasource.OnboardingLocalDataSource
import br.com.futebolnatv.data.onboarding.datasource.OnboardingLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(
            Constants.PREF_NAME, Context.MODE_PRIVATE
        )

    @Singleton
    @Provides
    fun provideSessionManager(preferences: SharedPreferences): OnboardingLocalDataSource =
        OnboardingLocalDataSourceImpl(preferences)
}
