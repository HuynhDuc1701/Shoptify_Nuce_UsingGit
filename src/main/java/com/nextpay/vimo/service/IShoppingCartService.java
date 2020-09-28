package com.nextpay.vimo.service;

import com.nextpay.vimo.model.ShoppingCart;
import com.nextpay.vimo.model.auth.User;

import java.util.Optional;

public interface IShoppingCartService extends IGeneralService<ShoppingCart> {
    Optional<ShoppingCart> findByUser(User user);
}
