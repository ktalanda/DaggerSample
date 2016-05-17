package example.com.daggersample;

import android.os.Bundle;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    String appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
