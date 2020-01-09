package com.example.myapplicationteams.model.data.di.modulo;

import com.example.myapplicationnuevo.BuildConfig;
import com.example.myapplicationteams.model.data.manager.WebServiceClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class TeamModule {

    @Provides
    @Singleton
    GsonConverterFactory providerGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor providerhttpLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    OkHttpClient providerOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofitClient(OkHttpClient builder, GsonConverterFactory gsonConverterFactory) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder)
                .build();

        return retrofit;
    }

    @Provides
    @Singleton
    WebServiceClient providerApiClient(Retrofit retrofit) {
        return retrofit.create(WebServiceClient.class);
    }

}
