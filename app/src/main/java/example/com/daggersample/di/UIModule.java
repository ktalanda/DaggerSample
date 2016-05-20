package example.com.daggersample.di;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

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
    @VoucherViewQualifier
    View provideVoucherViewHolder() {
        return LayoutInflater.from(activity).inflate(R.layout.view_voucher, null, true);
    }
}
