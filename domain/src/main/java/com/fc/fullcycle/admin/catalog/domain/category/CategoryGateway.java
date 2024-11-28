package com.fc.fullcycle.admin.catalog.domain.category;

import com.fc.fullcycle.admin.catalog.domain.pagination.Pagination;

import java.util.Optional;

public interface CategoryGateway {

    Category create(Category aCategory);
    void deleteById(CategoryID aInd);
    Optional<Category> findById(CategoryID anId);
    Category update(Category aCcategory);
    Pagination<Category> findAll(CategorySearchQuery aQuery);

}
