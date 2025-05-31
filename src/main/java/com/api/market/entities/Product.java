package com.api.market.entities;

import com.api.market.dto.ProductUpdateDTO;
import com.api.market.dto.RegisterProductsDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;

    public Product(@Valid RegisterProductsDTO data) {
        this.name = data.name();
        this.description = data.description();
        this.price = data.price();
    }


    public void updateData(ProductUpdateDTO data) {

        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.description() != null) {
            this.description = data.description();
        }
        if (data.price() != null) {
            this.price = data.price();
        }
    }
}
