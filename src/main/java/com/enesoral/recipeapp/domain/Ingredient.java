package com.enesoral.recipeapp.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"}, callSuper = true)
@Entity
public class Ingredient extends BaseEntity{

    private String description;
    private BigDecimal amount;

    @OneToOne
    private UnitOfMeasure uom;

    @ManyToOne
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

}
