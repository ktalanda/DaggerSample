package example.com.daggersample.ui;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import lombok.Getter;
import lombok.Setter;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    @Inject
    Provider<ItemViewHolder> itemViewHolderProvider;

    @Getter
    @Setter
    private List<String> data;

    @Inject
    public ItemAdapter() {
        data = new ArrayList<>();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return itemViewHolderProvider.get();
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
