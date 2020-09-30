package com.nextpay.vimo.service;

import com.nextpay.vimo.model.Item;
import com.nextpay.vimo.model.ShoppingCart;

public interface IItemService extends IGeneralService<Item> {
    Iterable<Item> findAllByShoppingCart(ShoppingCart shoppingCart);
}
