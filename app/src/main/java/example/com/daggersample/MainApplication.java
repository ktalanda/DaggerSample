package example.com.daggersample;

import android.app.Application;

import example.com.daggersample.di.AppComponent;

import example.com.daggersample.di.DaggerAppComponent;
import example.com.daggersample.di.MainActivityComponent;
import example.com.daggersample.di.UIModule;
import timber.log.Timber;

public class MainApplication extends Application {
    private AppComponent appComponent;
    private MainActivityComponent mainActivityComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        appComponent = DaggerAppComponent.builder()
                .build();
    }

    public MainActivityComponent createMainActivityComponent(MainActivity mainActivity) {
        mainActivityComponent = appComponent.plus(new UIModule(mainActivity));
        return mainActivityComponent;
    }

    public void releaseMainActivityComponent() {
        mainActivityComponent = null;
    }
}
