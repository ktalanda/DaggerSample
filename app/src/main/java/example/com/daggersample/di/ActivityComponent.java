package example.com.daggersample.di;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import example.com.daggersample.R;
import example.com.daggersample.presenter.MainPresenter;
import example.com.daggersample.ui.ItemAdapter;
import example.com.daggersample.ui.ItemViewHolder;
import example.com.daggersample.ui.MainActivity;

public class ActivityComponent {

    private MainActivity mainActivity;

    private static ActivityComponent applicationComponent;

    private static MainPresenter mainPresenter;
    private static ItemAdapter itemAdapter;

    private ActivityComponent(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public static ActivityComponent getInstance(MainActivity context) {
        if(applicationComponent == null) {
            applicationComponent = new ActivityComponent(context);
        }
        return applicationComponent;
    }

    public MainPresenter getMainPresenter() {
        if(mainPresenter == null) {
            mainPresenter = new MainPresenter();
        }
        return mainPresenter;
    }

    public ItemAdapter getItemAdapter() {
        if(itemAdapter == null) {
            itemAdapter = new ItemAdapter(mainActivity);
        }
        return itemAdapter;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(mainActivity);
    }

    public ItemViewHolder getViewHolder() {
        return new ItemViewHolder(LayoutInflater.from(mainActivity).inflate(R.layout.view_item, (ViewGroup) mainActivity.findViewById(R.id.list), false));
    }

    public List<String> getStringList() {
        return new ArrayList<>();
    }

}
