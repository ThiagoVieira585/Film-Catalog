package com.fc.fullcycle.admin.catalog.domain.validation.handler;

import com.fc.fullcycle.admin.catalog.domain.exceptions.DomainException;
import com.fc.fullcycle.admin.catalog.domain.validation.ValidatorError;
import com.fc.fullcycle.admin.catalog.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {

    @Override
    public ValidationHandler append(final ValidatorError validationError) {
        throw DomainException.with(validationError);
    }

    @Override
    public ValidationHandler append(ValidationHandler validationHandler) {
        throw DomainException.with(validationHandler.getErrors());
    }

    @Override
    public ValidationHandler validate(final Validation validation) {
        try {
            validation.validate();
        } catch (final DomainException ex) {
            throw DomainException.with(new ValidatorError(ex.getMessage()));
        }
        return this;
    }

    @Override
    public List<ValidatorError> getErrors() {
        return List.of();
    }

}
