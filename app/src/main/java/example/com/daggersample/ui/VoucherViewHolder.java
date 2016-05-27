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
import example.com.daggersample.domain.usecase.RetrieveVoucherUseCase;
import example.com.daggersample.presenter.MainPresenter;

public class VoucherViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.voucher_layout)
    View layout;

    @BindView(R.id.voucher_name)
    TextView name;

    @Inject
    MainPresenter mainPresenter;

    @Inject
    public VoucherViewHolder(@VoucherViewQualifier View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Voucher voucher) {
        name.setText(voucher.getCode());
        layout.setOnClickListener(v -> mainPresenter.retrieveVoucher(voucher.getCode()));
    }

}
