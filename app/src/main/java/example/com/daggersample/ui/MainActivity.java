package example.com.daggersample.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import example.com.daggersample.MainApplication;
import example.com.daggersample.R;
import example.com.daggersample.domain.entity.Voucher;
import example.com.daggersample.presenter.MainPresenter;
import retrofit2.Retrofit;

public class MainActivity extends BaseActivity implements MainPresenter.ViewInterface {

    @Inject
    VoucherAdapter voucherAdapter;

    @Inject
    Retrofit retrofit;

    @BindView(R.id.voucher_list)
    RecyclerView voucherList;

    @Inject
    MainPresenter mainPresenter;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        unbinder = ButterKnife.bind(this);

        mainPresenter.bind(this);

        mainPresenter.getVoucherList();

        voucherList.setLayoutManager(new LinearLayoutManager(this));
        voucherList.setAdapter(voucherAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.unbind();
    }

    @Override
    public void injectDependencies() {
        ((MainApplication) getApplication()).createMainActivityComponent(this).inject(this);
    }

    @Override
    public void resetDependencies() {
        ((MainApplication) getApplication()).releaseMainActivityComponent();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbinder.unbind();
    }

    @Override
    public void fillUpVoucherList(List<Voucher> list) {
        voucherAdapter.setData(list);
        voucherAdapter.notifyDataSetChanged();
    }
}
