package example.com.daggersample;

import android.support.v7.app.AppCompatActivity;

import example.com.daggersample.di.AppComponent;

public class BaseActivity extends AppCompatActivity {

    public AppComponent getAppComponent() {
        return ((MainApplication) getApplication()).getComponent();
    }
}
