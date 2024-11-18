package com.fc.fullcycle.admin.catalog.domain.category;

import java.time.Instant;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public class Category {
    private String id;
    private String name;
    private String description;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Category(
            final Instant deletedAt,
            final Instant updatedAt,
            final Instant createdAt,
            final boolean active,
            final String description,
            final String name,
            final String id
    ) {
        this.deletedAt = deletedAt;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.active = active;
        this.description = description;
        this.name = name;
        this.id = id;
    }

    public static Category newCategory(final String aName, final String aDescription, final boolean isActive) {
        final var id = UUID.randomUUID().toString();
        final var now = Instant.now();
        return new Category(null, now, now, isActive, aDescription,aName, id);


    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
}
