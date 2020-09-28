package com.nextpay.vimo.service.impl;

import com.nextpay.vimo.model.CustomerInfo;
import com.nextpay.vimo.repository.ICustomerInfoRepository;
import com.nextpay.vimo.service.ICustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerInfoServiceImpl implements ICustomerInfoService {

    @Autowired
    private ICustomerInfoRepository repository;

    @Override
    public Iterable<CustomerInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<CustomerInfo> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public CustomerInfo save(CustomerInfo customerInfo) {
        return repository.saveAndFlush(customerInfo);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
