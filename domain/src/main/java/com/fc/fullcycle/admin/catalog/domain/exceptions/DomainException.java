package com.fc.fullcycle.admin.catalog.domain.exceptions;

import java.util.List;

import com.fc.fullcycle.admin.catalog.domain.validation.ValidatorError;

public class DomainException extends RuntimeException {

    private final List<ValidatorError> errors;

    private DomainException(final List<ValidatorError> anErrors) {
        super("", null, true, false);
        this.errors = anErrors;
    }

    public static DomainException with(final List<ValidatorError> anErrors) {
        return new DomainException(anErrors);
    }

    public List<ValidatorError> getErrors() {
        return errors;
    }
}
