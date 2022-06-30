package com.ui_init_setup.practiceproject.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleTest {
    private final int WAIT_FOR_ELEMENT_TIMEOUT = 3000;
    private WebDriver driver;
    private WebDriverWait wdWait;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void openGoogle() {
        driver.get("https://google.com");

        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("Selenium");
    }

//        WebDriver driver = WebDriverFactory.CHROME.createDriver();
//    AuthConfig authConfig = ConfigurationManager.getAuthConfigInstance();
//
//    new JobertyHomePage(driver)
//            .get()
//            .openLoginModal()
//            .logInAs(authConfig.jobertyUsername(), authConfig.jobertyPassword())
//            .goToJobs()
//            .selectSeniority(Seniority.INTERNSHIP)
//            .enterSearchText("ux")
//            .search();
}
