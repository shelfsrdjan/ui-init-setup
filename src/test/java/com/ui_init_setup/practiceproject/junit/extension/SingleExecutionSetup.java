package com.ui_init_setup.practiceproject.junit.extension;

import org.junit.platform.launcher.TestExecutionListener;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class SingleExecutionSetup implements TestExecutionListener {

    private SingleExecutionSetup() { throw new AssertionError("Instantiation attempted from within class"); }

    private static void checkRequiredPropertiesFilesExist() {

        String browserProperties = "src/test/resources/properties/browser.properties";

        final List<Path> requiredPropertiesFiles = List.of(Path.of(browserProperties));

        for (Path path : requiredPropertiesFiles) {
            if (Files.notExists(path)) {
                throw new RuntimeException("Required property file at path: " + path + ", is missing");
            }
        }
    }
}
