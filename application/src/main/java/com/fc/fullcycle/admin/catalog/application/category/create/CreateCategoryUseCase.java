package com.fc.fullcycle.admin.catalog.application.category.create;

import com.fc.fullcycle.admin.catalog.application.UseCase;
import com.fc.fullcycle.admin.catalog.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class CreateCategoryUseCase
        extends UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>> {
}
