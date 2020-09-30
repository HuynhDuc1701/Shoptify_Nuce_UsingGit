package com.nextpay.vimo.service;

import com.nextpay.vimo.model.Orders;
import com.nextpay.vimo.model.Product;
import com.nextpay.vimo.model.auth.User;

public interface IOrdersService extends IGeneralService<Orders> {
    Iterable<Orders> findAllByUserAndStatus(User user, Boolean status);

    Iterable<Orders> findAllByStatus(Boolean status);

    Iterable<Product> findAllProductUserBought(User user);

    Long sumTotalPriceInput(Integer month, Integer year);
}
