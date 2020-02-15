package com.enesoral.recipeapp.domain;

import org.junit.Before;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() throws Exception {
        category = new Category();
    }

    @org.junit.Test
    public void getId() {
        Long idValue = 4L;
        category.setId(idValue);
        assertEquals(idValue, category.getId());
    }

    @org.junit.Test
    public void getName() {
        String americanCategory = "American";
        category.setName(americanCategory);
        assertEquals(americanCategory, category.getName());
    }
}