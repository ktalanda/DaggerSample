package example.com.daggersample.presenter;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainPresenter.ViewInterface>{

    @Inject
    public MainPresenter(){
    }

    public void addToList(String item) {
        view.addToList(item);
    }

    public void clearList() {
        view.clearList();
    }

    public interface ViewInterface {
        void addToList(String item);
        void clearList();
    }

}
