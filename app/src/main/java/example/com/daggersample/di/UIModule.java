package example.com.daggersample.di;

import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dagger.Module;
import dagger.Provides;
import example.com.daggersample.R;
import example.com.daggersample.di.qualifier.VoucherViewParentQualifier;
import example.com.daggersample.di.qualifier.VoucherViewQualifier;
import example.com.daggersample.ui.BaseActivity;

@Module
public class UIModule {
    private final BaseActivity activity;

    public UIModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(activity);
    }

    @VoucherViewParentQualifier
    @Provides
    ViewGroup provideVoucherMain() {
        return (ViewGroup) activity.findViewById(R.id.voucher_list);
    }

    @Provides
    @VoucherViewQualifier
    View provideVoucherViewHolder(LayoutInflater layoutInflater, @VoucherViewParentQualifier ViewGroup parent) {
        return layoutInflater.inflate(R.layout.view_voucher, parent, false);
    }

    @Provides
    AlertDialog.Builder provideAlertDialogBuilder() {
        return  new  AlertDialog.Builder(activity);
    }
}
