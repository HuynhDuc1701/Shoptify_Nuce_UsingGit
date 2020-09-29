package com.nextpay.vimo.service.impl;

import com.nextpay.vimo.model.Category;
import com.nextpay.vimo.repository.ICategoryRepository;
import com.nextpay.vimo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository repository;

    @Override
    public Iterable<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return repository.saveAndFlush(category);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
