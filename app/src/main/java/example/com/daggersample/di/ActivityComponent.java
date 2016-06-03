package example.com.daggersample.di;

import javax.inject.Singleton;

import dagger.Component;
import example.com.daggersample.ui.MainActivity;

@Singleton
@Component(
        modules = {
                ActivityModule.class
        }
)
public interface ActivityComponent {

        void inject(MainActivity mainActivity);
}
