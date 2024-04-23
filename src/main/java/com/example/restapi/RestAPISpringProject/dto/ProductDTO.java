package com.example.restapi.RestAPISpringProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private String count;
    @Min(value = 0, message = "weight should be more that 0")
    private int weight;
    @NotEmpty
    private String description;
    @NotEmpty
    private String type;

}
