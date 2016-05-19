package example.com.daggersample;

import android.app.Application;

import example.com.daggersample.di.AppComponent;
import example.com.daggersample.di.AppModule;
import example.com.daggersample.di.DaggerAppComponent;
import example.com.daggersample.di.UIModule;


public class MainApplication extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .uIModule(new UIModule(this))
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
