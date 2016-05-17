package example.com.daggersample;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
