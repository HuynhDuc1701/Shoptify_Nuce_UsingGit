package com.nextpay.vimo.repository;

import com.nextpay.vimo.model.Item;
import com.nextpay.vimo.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemRepository extends JpaRepository<Item, Long> {
    Iterable<Item> findAllByShoppingCart(ShoppingCart shoppingCart);
}
