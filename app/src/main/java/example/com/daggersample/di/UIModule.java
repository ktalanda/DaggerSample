package example.com.daggersample.di;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dagger.Module;
import dagger.Provides;
import example.com.daggersample.R;
import example.com.daggersample.di.qualifier.VoucherViewQualifier;

@Module
public class UIModule {
    private final Activity activity;

    public UIModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(activity);
    }

    @Provides
    @VoucherViewQualifier
    View provideVoucherViewHolder(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.view_voucher, (ViewGroup) activity.findViewById(R.id.voucher_main), false);
    }
}
