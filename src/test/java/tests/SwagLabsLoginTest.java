package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SwagLabsLoginPage;

import java.time.Duration;


public class SwagLabsLoginTest
{
    WebDriver driver;
    WebDriverWait wdWait;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wdWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    void shouldLoginAsStandardUser() {
        SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver,wdWait);
        swagLabsLoginPage.fetchCredentialsForStandardUser();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl());
    }

}
