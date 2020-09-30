package com.nextpay.vimo.service;

import com.nextpay.vimo.model.Product;
import com.nextpay.vimo.model.Review;
import com.nextpay.vimo.model.auth.User;

public interface IReviewService extends IGeneralService<Review> {
    Review findByUserAndProduct(User user, Product product);

    Iterable<Review> findAllByProduct(Product product);
}
