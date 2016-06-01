package example.com.daggersample.di.component;

import dagger.Subcomponent;
import example.com.daggersample.di.module.IntentModule;
import example.com.daggersample.di.module.LoginActivityModule;
import example.com.daggersample.di.scope.PerActivity;
import example.com.daggersample.ui.LoginActivity;

@PerActivity
@Subcomponent(modules = {
        LoginActivityModule.class,
        IntentModule.class
})
public interface LoginActivityComponent {
    LoginActivity inject(LoginActivity activity);
}
