package com.nextpay.vimo.service.impl;

import com.nextpay.vimo.model.auth.Role;
import com.nextpay.vimo.repository.IRoleRepository;
import com.nextpay.vimo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository repository;

    @Override
    public Role findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Iterable<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Role save(Role role) {
        return repository.saveAndFlush(role);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
