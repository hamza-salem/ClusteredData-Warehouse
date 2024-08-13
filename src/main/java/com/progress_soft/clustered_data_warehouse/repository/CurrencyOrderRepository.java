package com.progress_soft.clustered_data_warehouse.repository;

import com.progress_soft.clustered_data_warehouse.domain.CurrencyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyOrderRepository extends JpaRepository<CurrencyOrder, Long> {

    boolean existsByDealId(String dealId);

}
