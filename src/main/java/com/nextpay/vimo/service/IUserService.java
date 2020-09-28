package com.nextpay.vimo.service;

import com.nextpay.vimo.model.auth.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByEmail(String email);
}
