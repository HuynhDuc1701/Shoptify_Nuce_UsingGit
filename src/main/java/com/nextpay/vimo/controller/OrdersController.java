package com.nextpay.vimo.controller;

import com.nextpay.vimo.model.Orders;

import com.nextpay.vimo.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/Orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;

    @GetMapping
    public ResponseEntity<Iterable<Orders>> getAllOrders() {
        return new ResponseEntity<>(ordersService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrders(@PathVariable Long id) {
        Optional<Orders> OrdersOptional = ordersService.findById(id);
        return OrdersOptional.map(Orders -> new ResponseEntity<>(Orders, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Orders> createOrders(@RequestBody Orders Orders) {
        return new ResponseEntity<>(ordersService.save(Orders), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrders(@PathVariable Long id, @RequestBody Orders Orders) {
        Optional<Orders> OrdersOptional = ordersService.findById(id);
        return OrdersOptional.map(Orders1 -> {
            Orders.setId(Orders1.getId());
            ordersService.save(Orders);
            return new ResponseEntity<>(Orders, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Orders> deleteOrders(@PathVariable Long id) {
        Optional<Orders> OrdersOptional = ordersService.findById(id);
        return OrdersOptional.map(Orders -> {
            ordersService.remove(id);
            return new ResponseEntity<>(Orders, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
