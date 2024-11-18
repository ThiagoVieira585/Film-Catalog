package com.fc.fullcycle.admin.catalog.infrastructure;


import com.fc.fullcycle.admin.catalog.application.UseCase;

public class Main {
    public static void main(String[] args) {
        System.out.println(new UseCase().execute());
    }
}