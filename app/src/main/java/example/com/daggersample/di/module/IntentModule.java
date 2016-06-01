package example.com.daggersample.di.module;

import android.content.Intent;

import dagger.Module;
import dagger.Provides;
import example.com.daggersample.di.qualifier.LoginIntent;
import example.com.daggersample.di.qualifier.MainIntent;
import example.com.daggersample.ui.BaseActivity;
import example.com.daggersample.ui.LoginActivity;
import example.com.daggersample.ui.MainActivity;

@Module
public class IntentModule {

    private BaseActivity activity;

    public IntentModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    @MainIntent
    Intent provideMainIntent() {
        return new Intent(activity, MainActivity.class);
    }

    @Provides
    @LoginIntent
    Intent provideLoginIntent() {
        return new Intent(activity, LoginActivity.class);
    }
}
