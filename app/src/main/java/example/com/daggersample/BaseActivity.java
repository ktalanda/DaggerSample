package example.com.daggersample;

import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public AppComponent getAppComponent() {
        return ((MainApplication) getApplication()).getComponent();
    }
}
