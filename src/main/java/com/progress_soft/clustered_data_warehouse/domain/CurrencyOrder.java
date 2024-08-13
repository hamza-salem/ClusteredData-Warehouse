package com.progress_soft.clustered_data_warehouse.domain;



import com.progress_soft.clustered_data_warehouse.controller.requests.CurrencyOrderRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class CurrencyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dealId;

    private String fromCurrencyIsoCode;
    private String toCurrencyIsoCode;

    @CreationTimestamp
    private Timestamp creationTimestamp;
    private Timestamp dealTimestamp;


    private Double amount;


    public static CurrencyOrder getInstance(CurrencyOrderRequest currencyOrderRequest) {

        CurrencyOrder currencyOrder = new CurrencyOrder();
        currencyOrder.setDealId(currencyOrderRequest.getId());
        currencyOrder.setAmount(Double.valueOf(currencyOrderRequest.getAmount()));
        currencyOrder.setFromCurrencyIsoCode(currencyOrderRequest.getFromCurrencyIso());
        currencyOrder.setToCurrencyIsoCode(currencyOrderRequest.getToCurrencyIso());
        currencyOrder.setDealTimestamp(Timestamp.valueOf(currencyOrderRequest.getTimestamp()));
        return currencyOrder;

    }

    @Override
    public String toString() {
        return "CurrencyOrder{" +
                "id=" + id +
                ", dealId='" + dealId + '\'' +
                ", fromCurrencyIsoCode='" + fromCurrencyIsoCode + '\'' +
                ", toCurrencyIsoCode='" + toCurrencyIsoCode + '\'' +
                ", creationTimestamp=" + creationTimestamp +
                ", dealTimestamp=" + dealTimestamp +
                ", amount=" + amount +
                '}';
    }
}
