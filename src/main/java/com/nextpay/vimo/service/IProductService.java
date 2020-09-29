package com.nextpay.vimo.service;

import com.nextpay.vimo.model.Category;
import com.nextpay.vimo.model.Product;

public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> findAllByCategory(Category category);

    Iterable<Product> findAllBySaleOffGreaterThanZero();

    Iterable<Product> findAllByPriceCondition(double minValue, double maxValue);

    Iterable<Product> findAllProductOrderByDate();

    Iterable<Product> findAllByNameContaining(String name);
}
