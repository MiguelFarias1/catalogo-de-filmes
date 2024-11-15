package com.miguel.admin.catalogo.application;

import com.miguel.admin.catalogo.domain.category.Category;

public class UseCase {

    public Category execute() {
        return new Category();
    }
}