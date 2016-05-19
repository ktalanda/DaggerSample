package example.com.daggersample.di;

import dagger.Component;
import example.com.daggersample.MainActivity;

@Component(modules = {
        AppModule.class,
        UIModule.class
})
public interface AppComponent {
    void inject(MainActivity activity);
}
