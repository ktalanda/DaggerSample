package example.com.daggersample.di.component;

import dagger.Subcomponent;
import example.com.daggersample.di.module.IntentModule;
import example.com.daggersample.di.module.MainActivityModule;
import example.com.daggersample.di.module.UIModule;
import example.com.daggersample.di.scope.PerActivity;
import example.com.daggersample.ui.MainActivity;

@PerActivity
@Subcomponent(modules = {
        MainActivityModule.class,
        UIModule.class,
        IntentModule.class
})
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
