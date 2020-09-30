package com.nextpay.vimo.service.impl;

import com.nextpay.vimo.model.Orders;
import com.nextpay.vimo.model.Product;
import com.nextpay.vimo.model.auth.User;
import com.nextpay.vimo.repository.IOrdersRepository;
import com.nextpay.vimo.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersRepository repository;

    @Override
    public Iterable<Orders> findAllByUserAndStatus(User user, Boolean status) {
        return repository.findAllByUserAndStatus(user, status);
    }

    @Override
    public Iterable<Orders> findAllByStatus(Boolean status) {
        return repository.findAllByStatus(status);
    }

    @Override
    public Iterable<Product> findAllProductUserBought(User user) {
        return repository.findAllProductUserBought(user);
    }

    @Override
    public Long sumTotalPriceInput(Integer month, Integer year) {
        return repository.sumTotalPriceInput(month, year);
    }

    @Override
    public Iterable<Orders> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Orders save(Orders orders) {
        return repository.saveAndFlush(orders);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
