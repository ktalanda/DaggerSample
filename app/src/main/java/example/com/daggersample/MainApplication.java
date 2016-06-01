package example.com.daggersample;

import android.app.Application;
import android.content.Context;


import example.com.daggersample.di.component.AppComponent;
import example.com.daggersample.di.component.DaggerAppComponent;
import example.com.daggersample.di.component.UserComponent;
import example.com.daggersample.di.module.UserModule;
import lombok.Getter;
import timber.log.Timber;

public class MainApplication extends Application {
    @Getter
    private AppComponent appComponent;
    @Getter
    private UserComponent userComponent;

    public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .build();
    }

    public UserComponent createUserComponent(UserModule userModule) {
        userComponent = appComponent.plus(userModule);
        return userComponent;
    }

    public void releaseUserComponent() {
        userComponent = null;
    }

}
