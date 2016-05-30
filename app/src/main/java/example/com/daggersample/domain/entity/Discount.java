package example.com.daggersample.domain.entity;

import org.parceler.Parcel;

import example.com.daggersample.data.dto.DiscountDTO;
import lombok.Data;

@Data
@Parcel
public class Discount {
    String type;
    long amount_off;
    long percent_off;

    public Discount() {
    }

    public Discount(DiscountDTO dto) {
        this.type = dto.getType();
        this.amount_off = dto.getAmount_off();
        this.percent_off = dto.getPercent_off();
    }

    @Override
    public String toString() {
        return type + " " + (amount_off == 0 ? percent_off : amount_off);
    }
}
