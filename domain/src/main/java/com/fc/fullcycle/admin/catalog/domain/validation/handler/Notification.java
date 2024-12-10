package com.fc.fullcycle.admin.catalog.domain.validation.handler;

import com.fc.fullcycle.admin.catalog.domain.exceptions.DomainException;
import com.fc.fullcycle.admin.catalog.domain.validation.ValidationHandler;
import com.fc.fullcycle.admin.catalog.domain.validation.ValidatorError;

import java.util.ArrayList;
import java.util.List;

public class Notification implements ValidationHandler {

    private final List<ValidatorError> errors;

    private Notification(final List<ValidatorError> errors) {
        this.errors = errors;
    }

    public static Notification create() {
        return new Notification(new ArrayList<>());
    }

    public static Notification create(final Throwable t) {
        return create(new ValidatorError(t.getMessage()));
    }

    public static Notification create(final ValidatorError anError) {
        return new Notification(new ArrayList<>()).append(anError);
    }

    @Override
    public Notification append(final ValidatorError anError) {
        this.errors.add(anError);
        return this;
    }

    @Override
    public Notification append(final ValidationHandler anHandler) {
        this.errors.addAll(anHandler.getErrors());
        return this;
    }

    @Override
    public Notification validate(Validation aValidation) {
        try {
            aValidation.validate();
        } catch (final DomainException ex) {
            this.errors.addAll(ex.getErrors());
        } catch (final Throwable t) {
            this.errors.add(new ValidatorError(t.getMessage()));
        }
        return this;
    }

    @Override
    public List<ValidatorError> getErrors() {
        return this.errors;
    }
}
