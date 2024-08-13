package com.progress_soft.clustered_data_warehouse.controller;


import com.progress_soft.clustered_data_warehouse.controller.requests.CurrencyOrderRequest;
import com.progress_soft.clustered_data_warehouse.service.CurrencyOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/currency-orders")
public class CurrencyOrderController {

    @Autowired
    private CurrencyOrderService currencyOrderService;



    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody @Validated CurrencyOrderRequest currencyOrderRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldError().getDefaultMessage();
            log.error("received order with error {}",errorMessage);
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
        try {
            log.info("received order {}",currencyOrderRequest);
            currencyOrderService.createRecord(currencyOrderRequest);
        }catch (Exception e){
            log.error("error {}",e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(null);
    }


}
