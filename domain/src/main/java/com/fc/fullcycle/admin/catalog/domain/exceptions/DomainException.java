package com.fc.fullcycle.admin.catalog.domain.exceptions;

import java.util.List;

import com.fc.fullcycle.admin.catalog.domain.validation.ValidatorError;

public class DomainException extends NoStacktraceException {

    private final List<ValidatorError> errors;

    private DomainException(final String aMessage, final List<ValidatorError> anErrors) {
        super(aMessage);
        this.errors = anErrors;
    }

    public static DomainException with(final ValidatorError anError) {
        return new DomainException(anError.message(), List.of(anError));
    }

    public static DomainException with(final List<ValidatorError> anErrors) {
        return new DomainException("", anErrors);
    }

    public List<ValidatorError> getErrors() {
        return errors;
    }
}
