package com.fc.fullcycle.admin.catalog.application;

import com.fc.fullcycle.admin.catalog.domain.category.Category;

public class UseCase {
    public Category execute() {
        return new Category();
    }
}