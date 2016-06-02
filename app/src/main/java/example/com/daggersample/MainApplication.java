package example.com.daggersample;

import android.app.Application;
import android.content.Context;

import timber.log.Timber;

public class MainApplication extends Application {

    public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }

}
