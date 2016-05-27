package example.com.daggersample.domain.entity;

import org.parceler.Parcel;

import java.util.Date;

import example.com.daggersample.data.dto.VoucherDTO;
import lombok.Data;

@Parcel
@Data
public class Voucher {

    String code;
    String campaign;
    String category;
    Date startDate;
    Date expirationDate;
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
        this.startDate = dto.getStartDate();
        this.expirationDate = dto.getExpirationDate();
        this.active = dto.isActive();
        this.additionalInfo = dto.getAdditionalInfo();
        this.metadata = dto.getMetadata();
    }

}
