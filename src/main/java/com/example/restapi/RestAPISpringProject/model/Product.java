package com.example.restapi.RestAPISpringProject.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product extends BaseEntity  {
    @NotEmpty
    @Column(name = "name")
    private String name;
    @NotEmpty
    @Column(name = "count")
    private String count;
    @Min(value = 0, message = "weight should be more that 0")
    @Column(name = "weight")
    private int weight;
    @NotEmpty
    @Column(name = "description")
    private String description;
    @NotEmpty
    @Column(name = "type")
    private String type;


}
