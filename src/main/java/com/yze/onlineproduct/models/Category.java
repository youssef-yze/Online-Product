package com.yze.onlineproduct.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class Category extends AbsractEntity {

    private Integer code;
    private String label;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
