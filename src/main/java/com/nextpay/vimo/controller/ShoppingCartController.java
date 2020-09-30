package com.nextpay.vimo.controller;

import com.nextpay.vimo.model.ShoppingCart;
import com.nextpay.vimo.model.ShoppingCart;
import com.nextpay.vimo.service.IShoppingCartService;
import com.nextpay.vimo.service.impl.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/Shopping-cart")
public class ShoppingCartController {

    @Autowired
    private IShoppingCartService shoppingCartService;

    @GetMapping
    public ResponseEntity<Iterable<ShoppingCart>> getAllShoppingCart() {
        return new ResponseEntity<>(shoppingCartService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCart(@PathVariable Long id) {
        Optional<ShoppingCart> ShoppingCartOptional = shoppingCartService.findById(id);
        return ShoppingCartOptional.map(ShoppingCart -> new ResponseEntity<>(ShoppingCart, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ShoppingCart> createShoppingCart(@RequestBody ShoppingCart ShoppingCart) {
        return new ResponseEntity<>(shoppingCartService.save(ShoppingCart), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCart> updateShoppingCart(@PathVariable Long id, @RequestBody ShoppingCart ShoppingCart) {
        Optional<ShoppingCart> ShoppingCartOptional = shoppingCartService.findById(id);
        return ShoppingCartOptional.map(ShoppingCart1 -> {
            ShoppingCart.setId(ShoppingCart1.getId());
            shoppingCartService.save(ShoppingCart);
            return new ResponseEntity<>(ShoppingCart, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ShoppingCart> deleteShoppingCart(@PathVariable Long id) {
        Optional<ShoppingCart> ShoppingCartOptional = shoppingCartService.findById(id);
        return ShoppingCartOptional.map(ShoppingCart -> {
            shoppingCartService.remove(id);
            return new ResponseEntity<>(ShoppingCart, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
