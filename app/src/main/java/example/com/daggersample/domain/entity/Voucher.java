package example.com.daggersample.domain.entity;

import org.parceler.Parcel;

import example.com.daggersample.data.dto.VoucherDTO;
import lombok.Data;

@Parcel
@Data
public class Voucher {

    String code;
    String campaign;
    String category;
    Discount discount;
    String startDate;
    String expirationDate;
    boolean active;
    String additionalInfo;
    String metadata;

    public Voucher() {
    }

    public Voucher(String code) {
        this.code = code;
    }

    public Voucher(VoucherDTO dto) {
        this.code = dto.getCode();
        this.campaign = dto.getCampaign();
        this.category = dto.getCategory();
        this.discount = new Discount(dto.getDiscount());
        this.startDate = dto.getStart_date();
        this.expirationDate = dto.getExpiration_date();
        this.active = dto.isActive();
        this.additionalInfo = dto.getAdditional_info();
        this.metadata = dto.getMetadata();
    }

    public VoucherDTO toDto() {
        VoucherDTO dto = new VoucherDTO();
        dto.setCode(this.code);
        dto.setCampaign(this.campaign);
        dto.setCategory(this.category);
        dto.setDiscount(this.discount.toDto());
        dto.setStart_date(this.startDate);
        dto.setExpiration_date(this.expirationDate);
        dto.setActive(this.active);
        dto.setAdditional_info(this.additionalInfo);
        dto.setMetadata(this.metadata);
        return dto;
    }

}
