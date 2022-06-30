package com.ui_init_setup.practiceproject.tests;

import com.ui_init_setup.practiceproject.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class BaseTest {

    WebDriver driver;
    WebDriverWait wdWait;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
//        WebDriverFactory.CHROME.createDriver();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wdWait = new WebDriverWait(driver, Duration.ofMillis(3000));
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
