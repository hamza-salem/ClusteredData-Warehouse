package com.progress_soft.clustered_data_warehouse.controller.requests;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class CurrencyOrderRequest {


    @NotBlank(message = "Id cannot be blank")
    private String id;
    @NotBlank(message = "fromCurrencyIso cannot be blank")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Invalid format for currency iso")
    private String fromCurrencyIso;
    @NotBlank(message = "toCurrencyIso cannot be blank")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Invalid format for currency iso")
    private String toCurrencyIso;
    @NotBlank(message = "timestamp cannot be blank")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$", message = "Invalid timestamp format. Expected format is yyyy-MM-dd HH:mm:ss.zzzz")
    private String timestamp;
    @NotBlank(message = "amount cannot be blank")
    private String amount;

    @Override
    public String toString() {
        return "CurrencyOrderRequest{" +
                "id='" + id + '\'' +
                ", fromCurrencyIso='" + fromCurrencyIso + '\'' +
                ", toCurrencyIso='" + toCurrencyIso + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
