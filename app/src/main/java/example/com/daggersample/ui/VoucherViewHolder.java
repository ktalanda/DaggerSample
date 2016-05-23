package example.com.daggersample.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.daggersample.R;
import example.com.daggersample.di.qualifier.VoucherViewQualifier;
import example.com.daggersample.domain.entity.Voucher;
import retrofit2.Retrofit;

public class VoucherViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.voucher_name)
    TextView name;

    @BindView(R.id.voucher_main)
    View main;

    @Inject
    Retrofit retrofit;

    @Inject
    public VoucherViewHolder(@VoucherViewQualifier View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Voucher voucher) {
        name.setText(voucher.getCode());
    }

}
