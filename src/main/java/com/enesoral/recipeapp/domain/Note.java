package com.enesoral.recipeapp.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Note extends BaseEntity {

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNote;
}
