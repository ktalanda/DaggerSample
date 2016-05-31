package example.com.daggersample.di;

import dagger.Subcomponent;
import example.com.daggersample.di.scope.PerActivity;
import example.com.daggersample.ui.MainActivity;

@PerActivity
@Subcomponent(modules = {
        UIModule.class,
        NetworkModule.class
})
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
