package com.nextpay.vimo.controller;


import com.nextpay.vimo.model.Category;
import com.nextpay.vimo.model.Notification;
import com.nextpay.vimo.service.impl.CategoryServiceImpl;
import com.nextpay.vimo.service.impl.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class NotificationController {

    @Autowired
    NotificationServiceImpl notificationService;

    @GetMapping
    public ResponseEntity<Iterable<Notification>> getAllCategory() {
        return new ResponseEntity<>(notificationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotification(@PathVariable Long id) {
        Optional<Notification> NotificationOptional = notificationService.findById(id);
        return NotificationOptional.map(Notification -> new ResponseEntity<>(Notification, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification Notification) {
        return new ResponseEntity<>(notificationService.save(Notification), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable Long id, @RequestBody Notification Notification) {
        Optional<Notification> NotificationOptional = notificationService.findById(id);
        return NotificationOptional.map(Notification1 -> {
            Notification.setId(Notification1.getId());
            notificationService.save(Notification);
            return new ResponseEntity<>(Notification, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Notification> deleteNotification(@PathVariable Long id) {
        Optional<Notification> NotificationOptional = notificationService.findById(id);
        return NotificationOptional.map(Notification -> {
            notificationService.remove(id);
            return new ResponseEntity<>(Notification, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
