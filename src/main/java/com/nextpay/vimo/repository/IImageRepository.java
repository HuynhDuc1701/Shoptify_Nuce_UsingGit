package com.nextpay.vimo.repository;

import com.nextpay.vimo.model.Image;
import com.nextpay.vimo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepository extends JpaRepository<Image, Long> {
    Iterable<Image> findAllByProduct(Product product);
}
