package com.fc.fullcycle.admin.catalog.domain.category;

import com.fc.fullcycle.admin.catalog.domain.validation.ValidationHandler;
import com.fc.fullcycle.admin.catalog.domain.validation.Validator;
import com.fc.fullcycle.admin.catalog.domain.validation.ValidatorError;

public class CategoryValidator extends Validator {

    private static final int NAME_MIN_LENGHT = 3;
    private static final int NAME_MAX_LENGHT = 255;

    private final Category category;

    protected CategoryValidator(final Category aCategory, final ValidationHandler aHandler) {
        super(aHandler);
        this.category = aCategory;
    }

    @Override
    public void validate() {
        checkNameConstraints();
    }

    private void checkNameConstraints() {
        final String name = category.getName();
        if(name==null) {
            this.validationHandler().append(new ValidatorError("'name' must not be null"));

        }
        if(name.isBlank()) {
            this.validationHandler().append(new ValidatorError("'name' must not be empty"));

        }
        final int length = name.trim().length();
        if (length > NAME_MAX_LENGHT || length < NAME_MIN_LENGHT){
            this.validationHandler().append(new ValidatorError("'name' must be between 3 and 255"));

        }
    }
}
