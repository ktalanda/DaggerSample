package example.com.daggersample.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoucherDTO {
    String code;
    String campaign;
    String category;
    DiscountDTO discount;
    String start_date;
    String expiration_date;
    boolean active;
    String additional_info;
    String metadata;
}
