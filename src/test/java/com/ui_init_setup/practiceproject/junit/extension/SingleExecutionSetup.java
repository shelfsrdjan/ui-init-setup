package com.ui_init_setup.practiceproject.junit.extension;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

import static com.ui_init_setup.practiceproject.constant.PropertyNameConstant.TARGET_ENV;

@Slf4j
public class SingleExecutionSetup implements TestExecutionListener {

    @SneakyThrows
    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {
        String envName = System.getProperty(TARGET_ENV);
        log.info("Running test suite on: " + envName.toUpperCase(Locale.ROOT) + " environment");
        checkRequiredPropertiesFilesExist();
    }

    private static void checkRequiredPropertiesFilesExist() {

        final List<Path> requiredPropertiesFiles = List.of(Path.of("src/test/resources/properties/browser.properties"));

        for (Path path : requiredPropertiesFiles) {
            if (Files.notExists(path)) {
                throw new RuntimeException("Required property file at path: " + path + ", is missing");
            }
        }
    }
}
