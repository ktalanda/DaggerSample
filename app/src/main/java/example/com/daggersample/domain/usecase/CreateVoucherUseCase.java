package example.com.daggersample.domain.usecase;

import javax.inject.Inject;

import example.com.daggersample.data.VoucherifyService;
import example.com.daggersample.di.scope.PerActivity;
import example.com.daggersample.domain.entity.Voucher;
import rx.Observable;

@PerActivity
public class CreateVoucherUseCase {

    @Inject
    VoucherifyService voucherifyService;

    @Inject
    public CreateVoucherUseCase() {
    }

    public Observable<Voucher> execute(Voucher voucher) {
        return voucherifyService.createVoucher(voucher.toDto())
                .map(Voucher::new);
    }

}
