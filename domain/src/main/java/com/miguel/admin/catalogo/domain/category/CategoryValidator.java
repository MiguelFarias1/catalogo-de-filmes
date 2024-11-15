package com.miguel.admin.catalogo.domain.category;

import com.miguel.admin.catalogo.domain.validation.Error;
import com.miguel.admin.catalogo.domain.validation.ValidationHandler;
import com.miguel.admin.catalogo.domain.validation.Validator;

public class CategoryValidator extends Validator {

    private final Category category;

    protected CategoryValidator(final Category category, ValidationHandler handler) {
        super(handler);

        this.category = category;
    }

    @Override
    public void validate() {

        checkNameConstraints();


    }

    private void checkNameConstraints() {

        final String name = category.getName();

        if(name == null) {
            this.validationHandler().append(new Error("'name should not be null'"));
        }

        assert name != null;

        if(name.isEmpty()) {
            this.validationHandler().append(new Error("'name should not be empty'"));
        }

        if(name.isBlank()) {
            this.validationHandler().append(new Error("'name should not be blank'"));
        }

        final var length = name.trim().length();

        if(length < 3 || length > 255) {
            this.validationHandler().append(new Error("'name must be between 3 and 255 characters'"));
        }
    }
}
