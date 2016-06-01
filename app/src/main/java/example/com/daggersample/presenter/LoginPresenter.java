package example.com.daggersample.presenter;

import javax.inject.Inject;

public class LoginPresenter extends BasePresenter<LoginPresenter.ViewInterface> {

    @Inject
    public LoginPresenter() {
    }

    public void login() {
        view.login();
    }

    public interface ViewInterface {
        void login();
    }
}
