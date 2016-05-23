package example.com.daggersample.data;

import java.util.List;

import example.com.daggersample.data.dto.VoucherDTO;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface VoucherifyService {
    @GET("vouchers/{code}")
    Observable<VoucherDTO> getVoucher(@Path("code") String code);

    @GET("vouchers")
    Observable<List<VoucherDTO>> listVouchers();
}
