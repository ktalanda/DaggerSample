package example.com.daggersample.data.dto;

import lombok.Data;

@Data
public class DiscountDTO {
    String type;
    long amount_off;
    long percent_off;
}
