package com.yze.onlineproduct.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder

public class Order extends AbsractEntity{

    private String codeOrder;
    private Integer quantity;

}
