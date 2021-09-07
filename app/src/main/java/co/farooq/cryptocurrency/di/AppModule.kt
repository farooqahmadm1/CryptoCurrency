package co.farooq.cryptocurrency.di

import co.farooq.cryptocurrency.common.Constants
import co.farooq.cryptocurrency.data.remote.CoinPaprikaAPI
import co.farooq.cryptocurrency.data.repository.CoinRepositoryImpl
import co.farooq.cryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

}