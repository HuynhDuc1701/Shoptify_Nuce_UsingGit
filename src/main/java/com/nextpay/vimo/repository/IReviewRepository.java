package com.nextpay.vimo.repository;

import com.nextpay.vimo.model.Product;
import com.nextpay.vimo.model.Review;
import com.nextpay.vimo.model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Long> {
    Review findByUserAndProduct(User user, Product product);

    Iterable<Review> findAllByProduct(Product product);
}
