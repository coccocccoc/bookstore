package com.example.demo.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.category.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
