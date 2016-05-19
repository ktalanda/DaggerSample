package example.com.daggersample.domain;

import lombok.Data;

@Data
public class Voucher {
    public Voucher(String name) {
        this.name = name;
    }
    String name;
}
