package example.com.daggersample.data.dto;

import org.parceler.Parcel;

import lombok.Data;

@Data
@Parcel
public class VoucherDTO {
    String code;
    String campaign;
    String category;
    DiscountDTO discount;
    String startDate;
    String expirationDate;
    boolean active;
    String additionalInfo;
    String metadata;
}
