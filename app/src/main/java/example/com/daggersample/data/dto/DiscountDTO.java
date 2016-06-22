package example.com.daggersample.data.dto;

import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDTO {
    @Expose
    String type;
    @Expose
    Long amount_off;
    @Expose
    Long percent_off;
}
