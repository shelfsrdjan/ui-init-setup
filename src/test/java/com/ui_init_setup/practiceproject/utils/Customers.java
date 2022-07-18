package com.ui_init_setup.practiceproject.utils;

public class Customers {

    public static String getCustomerId(String name) {
        return switch(name){
            case "john" -> "12212";
            case "mary" -> "4847474";
            case "tom" -> "293743";
            default    -> "";
        };
    }
}