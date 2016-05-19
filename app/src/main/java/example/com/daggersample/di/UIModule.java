package example.com.daggersample.di;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import dagger.Module;
import dagger.Provides;
import example.com.daggersample.R;
import example.com.daggersample.di.qualifier.VoucherViewQualifier;

@Module
public class UIModule {
    private final Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    @VoucherViewQualifier
    View provideVoucherViewHolder() {
        return LayoutInflater.from(context).inflate(R.layout.view_voucher, null, true);
    }
}
