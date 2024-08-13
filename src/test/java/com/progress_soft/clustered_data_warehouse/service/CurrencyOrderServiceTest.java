package com.progress_soft.clustered_data_warehouse.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.progress_soft.clustered_data_warehouse.controller.requests.CurrencyOrderRequest;
import com.progress_soft.clustered_data_warehouse.domain.CurrencyOrder;
import com.progress_soft.clustered_data_warehouse.repository.CurrencyOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CurrencyOrderServiceTest {
    @Mock
    private CurrencyOrderRepository currencyOrderRepository;

    @InjectMocks
    private CurrencyOrderService currencyOrderService;

    private CurrencyOrderRequest currencyOrderRequest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        currencyOrderRequest = new CurrencyOrderRequest();
        currencyOrderRequest.setId("12345");
        currencyOrderRequest.setFromCurrencyIso("USD");
        currencyOrderRequest.setToCurrencyIso("EUR");
        currencyOrderRequest.setTimestamp("2024-08-10 15:30:00");
        currencyOrderRequest.setAmount("1000.00");
    }

    @Test
    public void testCreateRecord_Success() throws Exception {
        when(currencyOrderRepository.existsByDealId(currencyOrderRequest.getId())).thenReturn(false);

        currencyOrderService.createRecord(currencyOrderRequest);

        verify(currencyOrderRepository, times(1)).save(any(CurrencyOrder.class));
    }

    @Test
    public void testCreateRecord_AlreadyExists() {
        when(currencyOrderRepository.existsByDealId(currencyOrderRequest.getId())).thenReturn(true);

        Exception exception = assertThrows(Exception.class, () -> {
            currencyOrderService.createRecord(currencyOrderRequest);
        });

        assertEquals("Record already exist", exception.getMessage());
        verify(currencyOrderRepository, never()).save(any(CurrencyOrder.class));
    }
}
