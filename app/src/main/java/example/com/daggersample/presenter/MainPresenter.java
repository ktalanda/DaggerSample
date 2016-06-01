package example.com.daggersample.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import example.com.daggersample.di.scope.PerActivity;
import example.com.daggersample.domain.entity.Discount;
import example.com.daggersample.domain.entity.Voucher;
import example.com.daggersample.domain.usecase.CreateVoucherUseCase;
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
    CreateVoucherUseCase createVoucherUseCase;

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
                .subscribe(this::prepareVoucherList);
    }

    public void createVoucher(String campaign) {
        Discount discount = new Discount();
        discount.setType("AMOUNT");
        discount.setAmount_off(10);
        createVoucherUseCase.execute(discount)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::prepareVoucherList,
                        throwable -> {
                            Log.e("KAMIL", "createVoucher: ", throwable);
                        });
    }

    private void prepareVoucherList(Voucher voucher) {
        List<String> list = new ArrayList<>();
        addToList(list, "Active",  voucher.isActive());
        addToList(list, "Campaign",  voucher.getCampaign());
        addToList(list, "Category",  voucher.getCategory());
        addToList(list, "Discount",  voucher.getDiscount().toString());
        addToList(list, "Additional info",  voucher.getAdditionalInfo());
        addToList(list, "Start date",  voucher.getStartDate());
        addToList(list, "End date",  voucher.getExpirationDate());
        addToList(list, "Metadata",  voucher.getMetadata());
        view.showVoucherDetails(voucher.getCode(), list);
    }

    private void addToList(List<String> list, String title, Object element) {
        if (element != null) {
            list.add(title + ": " + element.toString());
        }
    }

    private void errorHandler(Throwable throwable) {
        Timber.e(throwable.getMessage());
    }

    public interface ViewInterface {
        void fillUpVoucherList(List<Voucher> list);
        void showVoucherDetails(String title, List<String> voucherDetails);
    }

}
