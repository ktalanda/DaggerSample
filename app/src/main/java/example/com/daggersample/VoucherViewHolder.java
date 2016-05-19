package example.com.daggersample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.daggersample.di.qualifier.VoucherViewQualifier;
import example.com.daggersample.domain.Voucher;

public class VoucherViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.voucher_name)
    TextView name;

    @Inject
    public VoucherViewHolder(@VoucherViewQualifier View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Voucher voucher) {
        name.setText(voucher.getName());
    }

}
