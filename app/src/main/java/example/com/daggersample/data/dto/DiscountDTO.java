package example.com.daggersample.data.dto;

import org.parceler.Parcel;

import lombok.Data;

@Data
@Parcel
public class DiscountDTO {
    String type;
    long amount_off;
    long percent_off;
}
