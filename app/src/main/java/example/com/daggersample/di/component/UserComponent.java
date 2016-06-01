package example.com.daggersample.di.component;

import dagger.Subcomponent;
import example.com.daggersample.di.module.IntentModule;
import example.com.daggersample.di.module.MainActivityModule;
import example.com.daggersample.di.module.UIModule;
import example.com.daggersample.di.module.UserModule;
import example.com.daggersample.di.scope.PerUser;

@PerUser
@Subcomponent(
        modules = {
                UserModule.class
        }
)
public interface UserComponent {
        MainActivityComponent plus(MainActivityModule mainActivityModule, UIModule uiModule, IntentModule intentModule);
}
