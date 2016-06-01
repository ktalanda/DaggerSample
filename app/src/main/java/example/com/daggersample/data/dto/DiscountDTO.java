package example.com.daggersample.data.dto;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class DiscountDTO {
    @Expose
    String type;
    @Expose
    long amount_off;
    @Expose
    long percent_off;
}
