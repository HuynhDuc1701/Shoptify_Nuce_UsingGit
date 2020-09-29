package com.nextpay.vimo.service.impl;

import com.nextpay.vimo.model.Category;
import com.nextpay.vimo.model.Product;
import com.nextpay.vimo.repository.IProductRepository;
import com.nextpay.vimo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository repository;

    @Override
    public Iterable<Product> findAllByCategory(Category category) {
        return repository.findAllByCategory(category);
    }

    @Override
    public Iterable<Product> findAllBySaleOffGreaterThanZero() {
        return repository.findAllBySaleOffGreaterThanZero();
    }

    @Override
    public Iterable<Product> findAllByPriceCondition(double minValue, double maxValue) {
        return repository.findAllByPriceCondition(minValue, maxValue);
    }

    @Override
    public Iterable<Product> findAllProductOrderByDate() {
        return repository.findAllProductOrderByDate();
    }

    @Override
    public Iterable<Product> findAllByNameContaining(String name) {
        return repository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Product save(Product product) {
        long currentTime = System.currentTimeMillis();
        Date currentDate = new Date(currentTime);
        product.setCreatedDate(currentDate);
        return repository.saveAndFlush(product);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
