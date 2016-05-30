package example.com.daggersample.ui;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
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

        final ListView listView = new ListView(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        List<String> list = new ArrayList<>();
        addToList(list, "Campaign",  voucher.getCampaign());
        addToList(list, "Category",  voucher.getCategory());
        addToList(list, "Discount",  voucher.getDiscount().toString());
        addToList(list, "Additional info",  voucher.getAdditionalInfo());
        addToList(list, "Start date",  voucher.getStartDate());
        addToList(list, "End date",  voucher.getExpirationDate());
        addToList(list, "Metadata",  voucher.getMetadata());

        adapter.addAll(list);
        listView.setAdapter(adapter);

        alertDialogBuilderProvider.get()
                .setTitle(voucher.getCode())
                .setView(listView)
                .setPositiveButton("ADD", (dialog, which) -> {
                    dialog.cancel();
                })
                .setNegativeButton("CANCEL", (dialog, which) -> {
                    dialog.cancel();
                })
                .show();
    }

    private void addToList(List<String> list, String title, Object element) {
        if (element != null) {
            list.add(title + ": " + element.toString());
        }
    }

    @OnClick(R.id.fab_add)
    public void onFabClick() {


    }
}
