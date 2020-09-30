package com.nextpay.vimo.service.impl;

import com.nextpay.vimo.model.Product;
import com.nextpay.vimo.model.Review;
import com.nextpay.vimo.model.auth.User;
import com.nextpay.vimo.repository.IReviewRepository;
import com.nextpay.vimo.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements IReviewService {
    @Autowired
    private IReviewRepository repository;

    @Override
    public Review findByUserAndProduct(User user, Product product) {
        return repository.findByUserAndProduct(user, product);
    }

    @Override
    public Iterable<Review> findAllByProduct(Product product) {
        return repository.findAllByProduct(product);
    }

    @Override
    public Iterable<Review> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Review> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Review save(Review review) {
        return repository.saveAndFlush(review);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
