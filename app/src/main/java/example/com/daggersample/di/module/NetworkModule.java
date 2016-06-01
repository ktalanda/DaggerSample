package example.com.daggersample.di.module;

import dagger.Module;
import dagger.Provides;
import example.com.daggersample.data.AuthenticationInterceptor;
import example.com.daggersample.data.VoucherifyService;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

@Module
public class NetworkModule {

    @Provides
    AuthenticationInterceptor provideAuthenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Provides
    OkHttpClient provideOkHttpClient(AuthenticationInterceptor authenticationInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(authenticationInterceptor)
                .build();
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.voucherify.io/v1/")
                .client(okHttpClient)
                .build();
    }

    @Provides
    VoucherifyService provideVoucherifyService(Retrofit retrofit) {
        return retrofit.create(VoucherifyService.class);
    }
}
