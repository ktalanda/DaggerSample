package example.com.daggersample.presenter;

public class BasePresenter<V> {
    V view;

    public void bind(V view) {
        this.view = view;
    }

    public void unbind() {
        this.view = null;
    }
}
