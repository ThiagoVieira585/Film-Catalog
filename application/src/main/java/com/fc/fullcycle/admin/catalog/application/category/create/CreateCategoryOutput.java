package com.fc.fullcycle.admin.catalog.application.category.create;

import com.fc.fullcycle.admin.catalog.domain.category.Category;
import com.fc.fullcycle.admin.catalog.domain.category.CategoryID;

public record CreateCategoryOutput(
        CategoryID id
) {
     public static CreateCategoryOutput from(final Category aCategory) {
         return new CreateCategoryOutput(aCategory.getId());
     }
}
