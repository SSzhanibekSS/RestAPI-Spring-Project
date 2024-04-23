package com.example.restapi.RestAPISpringProject.services;

import com.example.restapi.RestAPISpringProject.dto.ProductDTO;
import com.example.restapi.RestAPISpringProject.model.Product;
import com.example.restapi.RestAPISpringProject.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public ProductService(ProductRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public void createNewProduct(ProductDTO productDTO) {
        Product product = maptoProduct(productDTO);
        product.setCreatedAt(LocalDateTime.now());
        repository.save(product);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> all = repository.findAll();
        List<ProductDTO> list = new ArrayList<>();
        if (!all.isEmpty()) {
            for (Product prod : all) {
                list.add(maptoProductDTO(prod));
            }
        }
        return list;
    }

    private ProductDTO maptoProductDTO(Product prod) {

        return mapper.map(prod, ProductDTO.class);
    }


    private Product maptoProduct(ProductDTO productDTO) {

        return mapper.map(productDTO, Product.class);
    }
}
