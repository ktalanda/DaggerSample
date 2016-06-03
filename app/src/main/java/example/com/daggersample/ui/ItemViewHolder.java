package example.com.daggersample.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.daggersample.R;

public class ItemViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.item_text)
    TextView textView;

    @Inject
    public ItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(String text) {
        textView.setText(text);
    }
}
