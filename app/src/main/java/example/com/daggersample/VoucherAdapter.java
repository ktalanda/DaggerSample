package example.com.daggersample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import example.com.daggersample.domain.Voucher;
import lombok.Getter;

public class VoucherAdapter extends RecyclerView.Adapter<VoucherViewHolder> {

    @Inject
    Provider<VoucherViewHolder> voucherViewHolderProvider;

    @Getter
    List<Voucher> data = new ArrayList<>();

    @Inject
    public VoucherAdapter() {
    }

    @Override
    public VoucherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_voucher, parent, false);
        return new VoucherViewHolder(v);
    }

    @Override
    public void onBindViewHolder(VoucherViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
