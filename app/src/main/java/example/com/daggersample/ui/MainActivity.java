package example.com.daggersample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import example.com.daggersample.R;
import example.com.daggersample.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainPresenter.ViewInterface {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.list)
    RecyclerView recyclerView;

    MainPresenter mainPresenter;

    ItemAdapter adapter;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        mainPresenter = new MainPresenter();
        mainPresenter.bind(this);
        adapter = new ItemAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
        adapter.getData().add("test_" + adapter.getData().size());
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.fab_clear)
    public void onFabClearClick() {
        adapter.setData(new ArrayList<>());
        adapter.notifyDataSetChanged();
    }

}
