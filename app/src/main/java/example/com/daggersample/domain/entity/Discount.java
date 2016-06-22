package example.com.daggersample.domain.entity;

import org.parceler.Parcel;

import example.com.daggersample.data.dto.DiscountDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Parcel
@Builder
@AllArgsConstructor
public class Discount {
    String type;
    Long amount_off;
    Long percent_off;

    public Discount() {
    }

    public Discount(DiscountDTO dto) {
        this.type = dto.getType();
        this.amount_off = dto.getAmount_off();
        this.percent_off = dto.getPercent_off();
    }

    public DiscountDTO toDto() {
        DiscountDTO dto = new DiscountDTO();
        dto.setType(this.getType());
        dto.setAmount_off(this.getAmount_off());
        dto.setPercent_off(this.getPercent_off());
        return dto;
    }

    @Override
    public String toString() {
        String result = type;
        if (amount_off != null) {
            result += amount_off;
        }
        if (percent_off != null) {
            result += percent_off;
        }
        return result;
    }
}
