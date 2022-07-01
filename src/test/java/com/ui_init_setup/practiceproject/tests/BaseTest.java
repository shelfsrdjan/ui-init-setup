package com.ui_init_setup.practiceproject.tests;

import com.ui_init_setup.practiceproject.webDriver.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class BaseTest {

    private final int WAIT_FOR_ELEMENT_TIMEOUT = 3000;
    WebDriver driver = WebDriverFactory.CHROME.createDriver();
    WebDriverWait wdWait;

    @BeforeEach
    void setupTest() {
        wdWait = new WebDriverWait(driver, Duration.ofMillis(WAIT_FOR_ELEMENT_TIMEOUT));
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
