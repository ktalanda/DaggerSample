package example.com.daggersample.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import example.com.daggersample.MainApplication;
import example.com.daggersample.R;
import example.com.daggersample.di.module.IntentModule;
import example.com.daggersample.di.module.LoginActivityModule;
import example.com.daggersample.di.module.UserModule;
import example.com.daggersample.di.qualifier.MainIntent;
import example.com.daggersample.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity implements LoginPresenter.ViewInterface{

    @Inject
    @MainIntent
    Intent mainIntent;
    @Inject
    LoginPresenter loginPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unbinder = ButterKnife.bind(this);
        loginPresenter.bind(this);

        setSupportActionBar(toolbar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void injectDependencies() {
        MainApplication.get(this)
                .getAppComponent()
                .plus(new LoginActivityModule(this), new IntentModule(this))
                .inject(this);
    }

    @Override
    public void resetDependencies() {
    }

    @OnClick(R.id.login_button)
    public void clickLogin() {
        loginPresenter.login();
    }

    @Override
    public void login() {
        MainApplication.get(this)
                .createUserComponent(new UserModule());
        startActivity(mainIntent);
    }
}
