package example.com.daggersample.di;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
})
public interface AppComponent {
    MainActivityComponent plus(UIModule uiModule);
}