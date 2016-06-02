package example.com.daggersample.ui;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import example.com.daggersample.di.ActivityComponent;
import lombok.Getter;
import lombok.Setter;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private ActivityComponent activityComponent;

    @Getter
    @Setter
    private List<String> data;

    public ItemAdapter(MainActivity mainActivity) {
        activityComponent = ActivityComponent.getInstance(mainActivity);
        this.data = activityComponent
                .getStringList();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return activityComponent.getViewHolder();
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
