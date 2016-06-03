package example.com.daggersample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import example.com.daggersample.R;
import example.com.daggersample.di.ActivityComponent;
import example.com.daggersample.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainPresenter.ViewInterface {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.list)
    RecyclerView recyclerView;

    MainPresenter mainPresenter;
    ItemAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        ActivityComponent.getInstance(this)
                .inject(this);

        mainPresenter.bind(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        setSupportActionBar(toolbar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.unbind();
        unbinder.unbind();
    }

    @OnClick(R.id.fab_add)
    public void onFabClick() {
        mainPresenter.addToList("test_" + adapter.getData().size());
    }

    @OnClick(R.id.fab_clear)
    public void onFabClearClick() {
        mainPresenter.clearList();
    }

    @Override
    public void addToList(String item) {
        adapter.getData().add(item);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void clearList() {
        adapter.setData(new ArrayList<>());
        adapter.notifyDataSetChanged();
    }
}
