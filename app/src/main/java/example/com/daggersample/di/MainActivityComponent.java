package example.com.daggersample.di;

import dagger.Subcomponent;
import example.com.daggersample.MainActivity;
import example.com.daggersample.di.scope.PerActivity;

@PerActivity
@Subcomponent(modules = {
        UIModule.class
})
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
