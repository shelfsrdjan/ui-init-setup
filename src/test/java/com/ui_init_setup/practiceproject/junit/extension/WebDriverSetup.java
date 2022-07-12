package com.ui_init_setup.practiceproject.junit.extension;

import com.ui_init_setup.practiceproject.webDriver.SupportedWebDriverProvider;
import com.ui_init_setup.practiceproject.webDriver.ThreadLocalDriver;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;

public class WebDriverSetup implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        WebDriver driver = SupportedWebDriverProvider.getSupportedBrowser();
        ThreadLocalDriver.addDriver(driver);
    }

    @Override
    public void afterEach(ExtensionContext context) {
        if (ThreadLocalDriver.getDriver() != null) {
            ThreadLocalDriver.getDriver().quit();
            ThreadLocalDriver.removeDriver();
        }
    }
}