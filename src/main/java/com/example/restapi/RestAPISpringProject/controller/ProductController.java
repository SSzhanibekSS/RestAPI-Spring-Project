package com.example.restapi.RestAPISpringProject.controller;

import com.example.restapi.RestAPISpringProject.dto.ProductDTO;
import com.example.restapi.RestAPISpringProject.services.ProductService;
import com.example.restapi.RestAPISpringProject.util.ErrorMsg;
import com.example.restapi.RestAPISpringProject.util.InvalidProductException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/prod")
public class ProductController {
    private final ProductService service;
    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public String addNewProduct(@RequestBody @Valid ProductDTO productDTO,
                                BindingResult result){
        if(result.hasErrors()){
            StringBuilder builder = new StringBuilder();
            builder.append("Please check this fields");
            for(FieldError error: result.getFieldErrors()){
                builder.append(error.getField());
                builder.append(" - ");
                builder.append(error.getDefaultMessage());
                builder.append("; ");
            }

            throw new InvalidProductException(builder.toString());
        }

        service.createNewProduct(productDTO);
        return "Product successful created at :" + LocalDateTime.now();
    }

    @GetMapping("/all")
    public List<ProductDTO> getAllProducts(){
        return service.getAllProducts();

    }
    public ResponseEntity<ErrorMsg> handleInvalidProductException(InvalidProductException e){
        ErrorMsg errorMsg = new ErrorMsg(LocalDate.now(), e.getMessage());

        return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
    }
}

