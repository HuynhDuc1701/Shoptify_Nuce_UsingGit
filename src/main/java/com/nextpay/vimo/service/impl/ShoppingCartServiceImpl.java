package com.nextpay.vimo.service.impl;

import com.nextpay.vimo.model.ShoppingCart;
import com.nextpay.vimo.model.auth.User;
import com.nextpay.vimo.repository.IShoppingCartRepository;
import com.nextpay.vimo.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements IShoppingCartService {
    @Autowired
    private IShoppingCartRepository repository;

    @Override
    public Optional<ShoppingCart> findByUser(User user) {
        return repository.findByUser(user);
    }

    @Override
    public Iterable<ShoppingCart> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ShoppingCart> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return repository.saveAndFlush(shoppingCart);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
