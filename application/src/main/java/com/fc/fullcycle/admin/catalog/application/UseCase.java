package com.fc.fullcycle.admin.catalog.application;

import com.fc.fullcycle.admin.catalog.domain.category.Category;

public abstract class UseCase<IN, OUT> {

    public abstract OUT execute(IN anIn);


}