package com.ui_init_setup.practiceproject.models;

public record Account(
        int id,
        int customerId,
        String type,
        double balance) {
}