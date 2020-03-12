package com.enesoral.recipeapp.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class UnitOfMeasure extends BaseEntity {

    private String description;
}
