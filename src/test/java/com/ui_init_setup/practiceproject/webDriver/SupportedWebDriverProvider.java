package com.ui_init_setup.practiceproject.webDriver;

import com.ui_init_setup.practiceproject.config.propertybased.ConfigurationManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SupportedWebDriverProvider {

    public static WebDriver getSupportedBrowser(String desiredBrowser) {
        try {
            return WebDriverFactory.valueOf(desiredBrowser.toUpperCase()).createDriver();
        } catch (IllegalArgumentException ex) {
            log.error("Non-supported browser requested: {}, defaulting to Chrome", desiredBrowser);
        }
        return WebDriverFactory.CHROME.createDriver();
    }

    public static WebDriver getSupportedBrowser() {
        String propertyDefinedDriver = ConfigurationManager.getBrowserConfigInstance().defaultBrowser();
        try {
            return WebDriverFactory.valueOf(propertyDefinedDriver.toUpperCase()).createDriver();
        } catch (IllegalArgumentException ex) {
            log.error("Non-supported browser defined in browser properties file: {}, defaulting to Chrome", propertyDefinedDriver);
        }
        return WebDriverFactory.CHROME.createDriver();
    }
}
