package com.nextpay.vimo.service.impl;

import com.nextpay.vimo.model.Item;
import com.nextpay.vimo.model.ShoppingCart;
import com.nextpay.vimo.repository.IItemRepository;
import com.nextpay.vimo.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService implements IItemService {
    @Autowired
    private IItemRepository repository;

    @Override
    public Iterable<Item> findAllByShoppingCart(ShoppingCart shoppingCart) {
        return repository.findAllByShoppingCart(shoppingCart);
    }

    @Override
    public Iterable<Item> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Item> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Item save(Item item) {
        return repository.saveAndFlush(item);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
