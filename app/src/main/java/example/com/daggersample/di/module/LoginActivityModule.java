package example.com.daggersample.di.module;

import dagger.Module;
import dagger.Provides;
import example.com.daggersample.di.scope.PerActivity;
import example.com.daggersample.ui.LoginActivity;

@Module
public class LoginActivityModule {
    private LoginActivity activity;

    public LoginActivityModule(LoginActivity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    LoginActivity provideLoginActivity() {
        return activity;
    }
}
