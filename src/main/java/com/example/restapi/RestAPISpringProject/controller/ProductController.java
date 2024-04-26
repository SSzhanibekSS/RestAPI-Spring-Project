package com.example.restapi.RestAPISpringProject.controller;

import com.example.restapi.RestAPISpringProject.dto.ProductDTO;
import com.example.restapi.RestAPISpringProject.services.ProductService;
import com.example.restapi.RestAPISpringProject.util.ErrorMsg;
import com.example.restapi.RestAPISpringProject.util.InvalidProductException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    @Operation(
            summary = "Add a new product",
            description = "Endpoint for adding a new product. Validates the product data and saves the new product to the database.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Product added successfully"),
                    @ApiResponse(responseCode = "400", description = "Bad request. Check the request body for errors"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
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
    @Operation(
            summary = "Get all products",
            description = "Endpoint for retrieving all products from the database.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Products retrieved successfully"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/all")
    public List<ProductDTO> getAllProducts(){
        return service.getAllProducts();

    }
    public ResponseEntity<ErrorMsg> handleInvalidProductException(InvalidProductException e){
        ErrorMsg errorMsg = new ErrorMsg(LocalDate.now(), e.getMessage());

        return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
    }
}

