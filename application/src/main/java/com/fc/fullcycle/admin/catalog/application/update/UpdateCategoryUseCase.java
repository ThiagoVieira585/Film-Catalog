package com.fc.fullcycle.admin.catalog.application.update;

import com.fc.fullcycle.admin.catalog.application.UseCase;
import com.fc.fullcycle.admin.catalog.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateCategoryUseCase extends UseCase<UpdateCategoryCommand, Either<Notification, UpdateCategoryOutput>> {

}
