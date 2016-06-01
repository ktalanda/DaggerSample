package example.com.daggersample.di.module;

import dagger.Module;
import dagger.Provides;
import example.com.daggersample.di.scope.PerActivity;
import example.com.daggersample.ui.MainActivity;

@Module
public class MainActivityModule {
    private MainActivity activity;

    public MainActivityModule(MainActivity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    MainActivity provideLoginActivity() {
        return activity;
    }
}
