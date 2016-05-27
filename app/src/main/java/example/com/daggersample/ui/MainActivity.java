package example.com.daggersample.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    MainPresenter mainPresenter;

    @Inject
    Provider<AlertDialog.Builder> alertDialogBuilderProvider;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        mainPresenter.bind(this);

        setSupportActionBar(toolbar);

        voucherList.setLayoutManager(new LinearLayoutManager(this));
        voucherList.setAdapter(voucherAdapter);
        mainPresenter.getVoucherList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.unbind();
        unbinder.unbind();
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
    public void fillUpVoucherList(List<Voucher> list) {
        voucherAdapter.setData(list);
        voucherAdapter.notifyDataSetChanged();
    }

    @Override
    public void showVoucherDetails(Voucher voucher) {
        alertDialogBuilderProvider.get()
                .setTitle(voucher.getCampaign())
                .setPositiveButton("ADD", (dialog, which) -> {
                    dialog.cancel();
                })
                .setNegativeButton("CANCEL", (dialog, which) -> {
                    dialog.cancel();
                })
                .show();
    }

    @OnClick(R.id.fab_add)
    public void onFabClick() {


    }
}
