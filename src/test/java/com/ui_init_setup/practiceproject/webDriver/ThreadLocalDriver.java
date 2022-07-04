package com.ui_init_setup.practiceproject.webDriver;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalDriver {

    private ThreadLocalDriver() {
        throw new AssertionError("Instantiation attempted from within class");
    }

    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    // quit the drivers and browsers at the end only
    private static final List<WebDriver> storedDrivers = new ArrayList<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> storedDrivers.forEach(WebDriver::quit)));
    }

    public static WebDriver getDriver() {
        return drivers.get();
    }

    public static void addDriver(WebDriver driver) {
        storedDrivers.add(driver);
        drivers.set(driver);
    }

    public static void removeDriver() {
        storedDrivers.remove(drivers.get());
        drivers.remove();
    }
}
