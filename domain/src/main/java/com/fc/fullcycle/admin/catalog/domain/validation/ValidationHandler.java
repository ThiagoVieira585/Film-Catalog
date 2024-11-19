package com.fc.fullcycle.admin.catalog.domain.validation;

import java.util.List;

public interface ValidationHandler {

    ValidationHandler append(ValidatorError anError);
    ValidationHandler append(ValidationHandler anHandler);
    ValidationHandler validate(Validation aValidation);

    List<ValidatorError> getErrors();

    default boolean hasErrors() {
        return getErrors() != null && !getErrors().isEmpty();
    }

    public interface Validation {
        void validate();
    }
}
