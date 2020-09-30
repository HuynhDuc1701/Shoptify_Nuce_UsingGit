package com.nextpay.vimo.service;

import com.nextpay.vimo.model.Image;
import com.nextpay.vimo.model.Product;

public interface IImageService extends IGeneralService<Image> {
    Iterable<Image> findAllByProduct(Product product);
}
