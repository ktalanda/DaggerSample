package example.com.daggersample.ui;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import example.com.daggersample.di.scope.PerActivity;
import example.com.daggersample.domain.entity.Voucher;
import lombok.Getter;
import lombok.Setter;

@PerActivity
public class VoucherAdapter extends RecyclerView.Adapter<VoucherViewHolder> {

    @Inject
    Provider<VoucherViewHolder> voucherViewHolderProvider;

    @Getter
    @Setter
    List<Voucher> data = new ArrayList<>();

    @Inject
    public VoucherAdapter() {
    }

    @Override
    public VoucherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        VoucherViewHolder vh = voucherViewHolderProvider.get();
        return vh;
    }

    @Override
    public void onBindViewHolder(VoucherViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
}
