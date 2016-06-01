package example.com.daggersample.di.component;

import javax.inject.Singleton;

import dagger.Component;
import example.com.daggersample.di.module.IntentModule;
import example.com.daggersample.di.module.LoginActivityModule;
import example.com.daggersample.di.module.NetworkModule;
import example.com.daggersample.di.module.UserModule;

@Singleton
@Component(modules = {
        NetworkModule.class
})
public interface AppComponent {
    LoginActivityComponent plus(LoginActivityModule loginActivityModule, IntentModule intentModule);
    UserComponent plus(UserModule userModule);
}