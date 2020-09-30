package com.nextpay.vimo.service.impl;

import com.nextpay.vimo.model.Orders;
import com.nextpay.vimo.model.OrdersDetail;
import com.nextpay.vimo.repository.IOrderDetailRepository;
import com.nextpay.vimo.service.IOrdersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersDetailServiceImpl implements IOrdersDetailService {
    @Autowired
    private IOrderDetailRepository repository;

    @Override
    public Integer sumProductAmount(Long id) {
        return repository.sumProductAmount(id);
    }

    @Override
    public Iterable<OrdersDetail> findAllByOrders(Orders orders) {
        return repository.findAllByOrders(orders);
    }

    @Override
    public Iterable<OrdersDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<OrdersDetail> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public OrdersDetail save(OrdersDetail ordersDetail) {
        return repository.saveAndFlush(ordersDetail);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
