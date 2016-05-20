package example.com.daggersample;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import example.com.daggersample.domain.Voucher;

public class MainActivity extends BaseActivity {

    @Inject
    VoucherAdapter voucherAdapter;

    @BindView(R.id.voucher_list)
    RecyclerView voucherList;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        unbinder = ButterKnife.bind(this);

        voucherAdapter.getData().add(new Voucher("first"));
        voucherAdapter.getData().add(new Voucher("second"));
        voucherAdapter.getData().add(new Voucher("third"));
        voucherAdapter.getData().add(new Voucher("fourth"));

        voucherList.setLayoutManager(new LinearLayoutManager(this));
        voucherList.setAdapter(voucherAdapter);
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
}
