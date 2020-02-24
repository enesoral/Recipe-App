package com.enesoral.recipeapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"recipes"}, callSuper = true)
@Entity
public class Category extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;
}
