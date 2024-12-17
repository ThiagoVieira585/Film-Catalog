package com.fc.fullcycle.admin.catalog.application.update;

import com.fc.fullcycle.admin.catalog.domain.category.Category;
import com.fc.fullcycle.admin.catalog.domain.category.CategoryID;

public record UpdateCategoryOutput(
        CategoryID id
) {
    public static UpdateCategoryOutput from(final Category aCategory) {
        return new UpdateCategoryOutput(aCategory.getId());
    }
}
