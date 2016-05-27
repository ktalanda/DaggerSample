package example.com.daggersample.domain.usecase;

import javax.inject.Inject;

import example.com.daggersample.data.VoucherifyService;
import example.com.daggersample.domain.entity.Voucher;
import rx.Observable;

public class RetrieveVoucherUseCase {

    @Inject
    VoucherifyService voucherifyService;

    @Inject
    public RetrieveVoucherUseCase(){
    }

    public Observable<Voucher> execute(String code) {
        return voucherifyService.retrieveVoucher(code)
                .map(Voucher::new);
    }
}
