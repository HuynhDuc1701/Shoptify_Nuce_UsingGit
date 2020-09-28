package com.nextpay.vimo.service.impl;

import com.nextpay.vimo.model.Notification;
import com.nextpay.vimo.model.auth.User;
import com.nextpay.vimo.repository.INotificationRepository;
import com.nextpay.vimo.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationServiceImpl implements INotificationService {
    @Autowired
    private INotificationRepository repository;

    @Override
    public Iterable<Notification> findAllByStatusIsFalseAndUser(User user) {
        return repository.findAllByStatusIsFalseAndUser(user);
    }

    @Override
    public Iterable<Notification> findAll() {
        return repository.findAllDateDesc();
    }

    @Override
    public Optional<Notification> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Notification save(Notification notification) {
        return repository.saveAndFlush(notification);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
