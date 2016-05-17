package example.com.daggersample;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public String provideAppName() {
        return context.getString(R.string.app_name);
    }

}
