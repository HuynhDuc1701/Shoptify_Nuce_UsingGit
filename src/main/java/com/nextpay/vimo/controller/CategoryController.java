package com.nextpay.vimo.controller;

import com.nextpay.vimo.model.Category;
import com.nextpay.vimo.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    CategoryServiceImpl categoryService;
    @GetMapping
    public ResponseEntity<Iterable<Category>> getAllCategory() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        Optional<Category> CategoryOptional = categoryService.findById(id);
        return CategoryOptional.map(Category -> new ResponseEntity<>(Category, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category Category) {
        return new ResponseEntity<>(categoryService.save(Category), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category Category) {
        Optional<Category> CategoryOptional = categoryService.findById(id);
        return CategoryOptional.map(Category1 -> {
            Category.setId(Category1.getId());
            categoryService.save(Category);
            return new ResponseEntity<>(Category, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        Optional<Category> CategoryOptional = categoryService.findById(id);
        return CategoryOptional.map(Category -> {
            categoryService.remove(id);
            return new ResponseEntity<>(Category, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
