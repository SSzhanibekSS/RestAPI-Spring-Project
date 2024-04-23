package com.example.restapi.RestAPISpringProject.repositories;

import com.example.restapi.RestAPISpringProject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {


}
