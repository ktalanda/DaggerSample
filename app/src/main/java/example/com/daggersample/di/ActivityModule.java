package example.com.daggersample.di;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dagger.Module;
import dagger.Provides;
import example.com.daggersample.R;
import example.com.daggersample.ui.MainActivity;

@Module
public class ActivityModule {
    private MainActivity mainActivity;

    public ActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    MainActivity provideMainActivity() {
        return mainActivity;
    }

    @Provides
    View provideItemView() {
        return LayoutInflater.from(mainActivity).inflate(R.layout.view_item, (ViewGroup) mainActivity.findViewById(R.id.list), false);
    }

    @Provides
    RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(mainActivity);
    }
}
