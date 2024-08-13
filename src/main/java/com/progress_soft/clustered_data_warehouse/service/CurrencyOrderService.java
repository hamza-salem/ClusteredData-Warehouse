package com.progress_soft.clustered_data_warehouse.service;


import com.progress_soft.clustered_data_warehouse.controller.requests.CurrencyOrderRequest;
import com.progress_soft.clustered_data_warehouse.domain.CurrencyOrder;
import com.progress_soft.clustered_data_warehouse.repository.CurrencyOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CurrencyOrderService {

    @Autowired
    private CurrencyOrderRepository currencyOrderRepository;

    public void createRecord(CurrencyOrderRequest currencyOrderRequest) throws Exception {
        validateRecord(currencyOrderRequest);

        CurrencyOrder currencyOrder = CurrencyOrder.getInstance(currencyOrderRequest);

        currencyOrder = currencyOrderRepository.save(currencyOrder);
        log.info("saved order successfully {}", currencyOrder);
    }

    private void validateRecord(CurrencyOrderRequest currencyOrderRequest) throws Exception {
        if(currencyOrderRepository.existsByDealId(currencyOrderRequest.getId())){
            throw new Exception("Record already exist");
        }
    }
}
