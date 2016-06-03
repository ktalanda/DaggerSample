package example.com.daggersample.ui;

import example.com.daggersample.di.ActivityComponent;

public class MainActivityInjector {

    public void injectMembers(MainActivity mainActivity) {
        ActivityComponent activityComponent = ActivityComponent.getInstance(mainActivity);
        mainActivity.adapter = activityComponent.getItemAdapter();
        mainActivity.mainPresenter = activityComponent.getMainPresenter();
        mainActivity.layoutManager = activityComponent.getLayoutManager();

    }
}
