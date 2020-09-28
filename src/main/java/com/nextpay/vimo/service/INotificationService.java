package com.nextpay.vimo.service;

import com.nextpay.vimo.model.Notification;
import com.nextpay.vimo.model.auth.User;

public interface INotificationService extends IGeneralService<Notification>{
    Iterable<Notification> findAllByStatusIsFalseAndUser(User user);
}
