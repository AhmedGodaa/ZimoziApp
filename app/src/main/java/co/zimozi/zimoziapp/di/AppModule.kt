package co.zimozi.zimoziapp.di

import android.content.Context
import co.zimozi.zimoziapp.common.Constants.BASE_URL
import co.zimozi.zimoziapp.common.PreferencesManager
import co.zimozi.zimoziapp.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {




    @Singleton
    @Provides
    fun provideApplicationContext(
        @ApplicationContext context: Context
    ) = context


    @Singleton
    @Provides
    fun providePreferenceManager(@ApplicationContext applicationContext: Context) =
        PreferencesManager(applicationContext)


}