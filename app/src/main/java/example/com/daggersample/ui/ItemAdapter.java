package example.com.daggersample.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import example.com.daggersample.R;
import lombok.Getter;
import lombok.Setter;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    @Getter
    @Setter
    private List<String> data;

    public ItemAdapter() {
        this.data = new ArrayList<>();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false));
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
