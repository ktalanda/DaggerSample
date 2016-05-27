package example.com.daggersample.presenter;

import java.util.List;

import javax.inject.Inject;

import example.com.daggersample.di.scope.PerActivity;
import example.com.daggersample.domain.entity.Voucher;
import example.com.daggersample.domain.usecase.GetVoucherListUseCase;
import example.com.daggersample.domain.usecase.RetrieveVoucherUseCase;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

@PerActivity
public class MainPresenter extends BasePresenter<MainPresenter.ViewInterface>{

    @Inject
    GetVoucherListUseCase getVoucherListUseCase;

    @Inject
    RetrieveVoucherUseCase retrieveVoucherUseCase;

    @Inject
    public MainPresenter(){
    }

    public void getVoucherList(){
        getVoucherListUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toList()
                .subscribe(
                    view::fillUpVoucherList,
                        this::errorHandler);
    }

    public void retrieveVoucher(String code) {
        retrieveVoucherUseCase.execute(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showVoucherDetails);
    }

    private void errorHandler(Throwable throwable) {
        Timber.e(throwable.getMessage());
    }

    public interface ViewInterface {
        void fillUpVoucherList(List<Voucher> list);
        void showVoucherDetails(Voucher voucher);
    }

}
