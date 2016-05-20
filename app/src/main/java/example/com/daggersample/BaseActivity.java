package example.com.daggersample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        resetDependencies();
    }

    public abstract void injectDependencies();
    public abstract void resetDependencies();
}
