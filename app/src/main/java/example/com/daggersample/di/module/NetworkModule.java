package example.com.daggersample.di.module;

import dagger.Module;
import dagger.Provides;
import example.com.daggersample.data.AuthenticationInterceptor;
import example.com.daggersample.data.VoucherifyService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class NetworkModule {

    @Provides
    AuthenticationInterceptor provideAuthenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    OkHttpClient provideOkHttpClient(AuthenticationInterceptor authenticationInterceptor, HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(authenticationInterceptor)
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Provides
    Converter.Factory provideConverterFactory() {
        return MoshiConverterFactory.create();
    }

    @Provides
    CallAdapter.Factory provideCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Converter.Factory converterFactory, CallAdapter.Factory callAdapterFactory) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(callAdapterFactory)
                .addConverterFactory(converterFactory)
                .baseUrl("https://api.voucherify.io/v1/")
                .client(okHttpClient)
                .build();
    }

    @Provides
    VoucherifyService provideVoucherifyService(Retrofit retrofit) {
        return retrofit.create(VoucherifyService.class);
    }
}
