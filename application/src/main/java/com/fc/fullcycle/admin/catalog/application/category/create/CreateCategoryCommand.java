package com.fc.fullcycle.admin.catalog.application.category.create;

public record CreateCategoryCommand(
        String name,
        String description,
        boolean isActive
) {
    public static CreateCategoryCommand with(
            final String aName,
            final String aDescription,
            final boolean anIsActive) {
        return new CreateCategoryCommand(aName, aDescription, anIsActive);
    }
}
