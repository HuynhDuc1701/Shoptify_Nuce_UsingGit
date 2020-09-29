package com.nextpay.vimo.repository;

import com.nextpay.vimo.model.Category;
import com.nextpay.vimo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findAllByCategory(Category category);

    @Query("select p from Product p where p.saleOff>0")
    Iterable<Product> findAllBySaleOffGreaterThanZero();

    @Query("select p from Product  p where p.price >= ?1 and p.price <= ?2")
    Iterable<Product> findAllByPriceCondition(double minValue, double maxValue);

    @Query("select p from Product p order by p.createdDate asc ")
    Iterable<Product> findAllProductOrderByDate();

    Iterable<Product> findAllByNameContaining(String name);
}
