package com.fc.fullcycle.admin.catalog.application.update;

import com.fc.fullcycle.admin.catalog.domain.category.Category;
import com.fc.fullcycle.admin.catalog.domain.category.CategoryGateway;
import com.fc.fullcycle.admin.catalog.domain.category.CategoryID;
import com.fc.fullcycle.admin.catalog.domain.exceptions.DomainException;
import com.fc.fullcycle.admin.catalog.domain.validation.ValidatorError;
import com.fc.fullcycle.admin.catalog.domain.validation.handler.Notification;
import io.vavr.API;
import io.vavr.control.Either;

import java.util.Objects;
import java.util.function.Supplier;

public class DefaultUpdateCategoryUseCase extends UpdateCategoryUseCase {

   private final CategoryGateway categoryGateway;
   public DefaultUpdateCategoryUseCase(final CategoryGateway categoryGateway) {
       this.categoryGateway = Objects.requireNonNull(categoryGateway);
   }

    @Override
    public Either<Notification, UpdateCategoryOutput> execute(final UpdateCategoryCommand aComand       ) {
        final var anId = CategoryID.from(aComand.id());
        final var aName = aComand.name();
        final var aDescription = aComand.description();
        final var isActive = aComand.isActive();

        final var aCategory = this.categoryGateway.findById(anId)
                .orElseThrow(notFound(anId));

        final var notification = Notification.create();
        aCategory
                .update(aName, aDescription, isActive)
                .validate(notification);
        return notification.hasErrors() ? API.Left(notification) : update(aCategory);
    }

    private Either<Notification, UpdateCategoryOutput> update(final Category aCategory) {
       return API.Try(()-> this.categoryGateway.update(aCategory))
               .toEither()
               .bimap(Notification::create, UpdateCategoryOutput::from);
    }

    private Supplier<DomainException> notFound(CategoryID anId) {
       return () -> DomainException.with(new ValidatorError("Category with id %s not found".formatted(anId.getValue()))
       );
    }
}
