package br.com.futebolnatv.data.di

import br.com.futebolnatv.commons.constants.Constants
import br.com.futebolnatv.data.BuildConfig
import br.com.futebolnatv.data.match.datasource.MatchApiDataSource
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiDataSourceModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder().add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
            .build()

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG){
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }else{
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        oktHttpClient: OkHttpClient,
        moshi: Moshi,
        BASE_URL: String
    ): Retrofit =
        Retrofit.Builder()
            .client(oktHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
}
