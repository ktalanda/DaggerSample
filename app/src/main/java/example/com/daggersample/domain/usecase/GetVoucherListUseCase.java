package example.com.daggersample.domain.usecase;

import javax.inject.Inject;

import example.com.daggersample.data.VoucherifyService;
import example.com.daggersample.di.scope.PerActivity;
import example.com.daggersample.domain.entity.Voucher;
import rx.Observable;

@PerActivity
public class GetVoucherListUseCase {

    @Inject
    VoucherifyService voucherifyService;

    @Inject
    public GetVoucherListUseCase() {
    }

    public Observable<Voucher> execute() {
        return voucherifyService.listVouchers()
                .flatMap(Observable::from)
                .map(Voucher::new);
    }

}
