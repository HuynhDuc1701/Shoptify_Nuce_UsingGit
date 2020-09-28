package com.nextpay.vimo.repository;

import com.nextpay.vimo.model.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerInfoRepository extends JpaRepository<CustomerInfo, Long> {
}
