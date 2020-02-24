package com.enesoral.recipeapp.domain;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"}, callSuper = true)
@Entity
public class Note extends BaseEntity {

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNote;

    public Note() {
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof Note;
    }

}
