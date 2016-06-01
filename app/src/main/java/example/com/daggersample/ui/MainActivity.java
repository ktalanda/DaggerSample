package example.com.daggersample.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import example.com.daggersample.MainApplication;
import example.com.daggersample.R;
import example.com.daggersample.di.module.IntentModule;
import example.com.daggersample.di.module.MainActivityModule;
import example.com.daggersample.di.module.UIModule;
import example.com.daggersample.di.qualifier.LoginIntent;
import example.com.daggersample.domain.entity.Voucher;
import example.com.daggersample.presenter.MainPresenter;

public class MainActivity extends BaseActivity implements MainPresenter.ViewInterface {

    @BindView(R.id.voucher_list)
    RecyclerView voucherList;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    VoucherAdapter voucherAdapter;
    @Inject
    MainPresenter mainPresenter;
    @Inject
    Provider<AlertDialog.Builder> alertDialogBuilderProvider;
    @Inject
    @LoginIntent
    Intent loginIntent;

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
        MainApplication.get(this)
                .getUserComponent()
                .plus(new MainActivityModule(this), new UIModule(this), new IntentModule(this))
                .inject(this);
    }

    @Override
    public void resetDependencies() {
    }

    @OnClick(R.id.fab_add)
    public void onFabClick() {
        final EditText editText = new EditText(this);

        alertDialogBuilderProvider.get()
                .setTitle("Voucher Code")
                .setView(editText)
                .setPositiveButton("ADD", (dialog, which) -> {
                    mainPresenter.createVoucher(editText.getText().toString());
                    dialog.cancel();
                })
                .setNegativeButton("CLOSE", (dialog, which) -> {
                    dialog.cancel();
                })
                .show();
    }

    @OnClick(R.id.fab_logout)
    public void onLogoutClick() {
        mainPresenter.logout();
    }

    @Override
    public void fillUpVoucherList(List<Voucher> list) {
        voucherAdapter.setData(list);
        voucherAdapter.notifyDataSetChanged();
    }

    @Override
    public void showVoucherDetails(String title, List<String> voucherDetails) {

        final ListView listView = new ListView(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        adapter.addAll(voucherDetails);
        listView.setAdapter(adapter);

        alertDialogBuilderProvider.get()
                .setTitle(title)
                .setView(listView)
                .setNegativeButton("CLOSE", (dialog, which) -> {
                    dialog.cancel();
                })
                .show();
    }

    @Override
    public void logout() {
        MainApplication.get(this).releaseUserComponent();
        finish();
    }
}
