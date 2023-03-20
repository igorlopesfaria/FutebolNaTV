package br.com.futebolnatv.data.di

import br.com.futebolnatv.data.match.datasource.MatchApiDataSource
import br.com.futebolnatv.data.onboarding.datasource.OnboardingLocalDataSource
import br.com.futebolnatv.data.match.mapper.MatchMapper
import br.com.futebolnatv.data.match.mapper.MatchMapperImpl
import br.com.futebolnatv.data.match.mapper.TeamMapper
import br.com.futebolnatv.data.match.mapper.TeamMapperImpl
import br.com.futebolnatv.data.match.repository.MatchRepository
import br.com.futebolnatv.data.match.repository.MatchRepositoryImpl
import br.com.futebolnatv.data.onboarding.repository.OnboardingRepository
import br.com.futebolnatv.data.onboarding.repository.OnboardingRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
@Module
@InstallIn(ViewModelComponent::class)
object DataModule {
    @Provides
    fun provideMatchRepository(repository: MatchRepositoryImpl): MatchRepository = repository
    @Provides
    fun provideOnboardingRepository(repository: OnboardingRepositoryImpl): OnboardingRepository = repository
    @Provides
    fun provideTeamMapper(mapper: TeamMapperImpl): TeamMapper = mapper
    @Provides
    fun provideMatchMapper(mapper: MatchMapperImpl): MatchMapper = mapper
    @Provides
    fun provideOnboardingLocalDataSource(localDataSource: OnboardingLocalDataSource): OnboardingLocalDataSource = localDataSource
    @Provides
    fun provideMatchApiDataSource(retrofit: Retrofit) = retrofit.create(MatchApiDataSource::class.java)
}


