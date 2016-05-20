package example.com.daggersample.di;

import dagger.Component;
import example.com.daggersample.MainActivity;

@Component(modules = {
        UIModule.class
})
public interface AppComponent {
    void inject(MainActivity activity);
}
