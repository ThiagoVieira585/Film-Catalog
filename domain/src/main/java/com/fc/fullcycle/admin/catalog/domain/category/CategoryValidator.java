package com.fc.fullcycle.admin.catalog.domain.category;

import com.fc.fullcycle.admin.catalog.domain.validation.ValidationHandler;
import com.fc.fullcycle.admin.catalog.domain.validation.Validator;
import com.fc.fullcycle.admin.catalog.domain.validation.Error;

public class CategoryValidator extends Validator {

    private final Category category;

    protected CategoryValidator(final Category aCategory, final ValidationHandler aHandler) {
        super(aHandler);
        this.category = aCategory;
    }

    @Override
    public void validate() {
        if(this.category.getName()==null) {
            this.validationHandler().append(new Error("'name' must not be null"));
        }
    }
}
