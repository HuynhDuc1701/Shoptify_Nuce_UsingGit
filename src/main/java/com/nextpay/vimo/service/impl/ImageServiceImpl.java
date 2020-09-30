package com.nextpay.vimo.service.impl;

import com.nextpay.vimo.model.Image;
import com.nextpay.vimo.model.Product;
import com.nextpay.vimo.repository.IImageRepository;
import com.nextpay.vimo.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageServiceImpl implements IImageService {
    @Autowired
    private IImageRepository repository;

    @Override
    public Iterable<Image> findAllByProduct(Product product) {
        return repository.findAllByProduct(product);
    }

    @Override
    public Iterable<Image> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Image> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Image save(Image image) {
        return repository.saveAndFlush(image);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
