package com.yze.onlineproduct.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity

public class Order extends AbsractEntity{

    private String codeOrder;
    private String quantity;
}
