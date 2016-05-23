package example.com.daggersample.data.dto;

import org.parceler.Parcel;

import java.util.Date;

import lombok.Data;

@Data
@Parcel
public class VoucherDTO {
    String code;
    String campain;
    String category;
    Date startDate;
    Date expirationDate;
    boolean active;
    String additionalInfo;
    String metadata;
}
