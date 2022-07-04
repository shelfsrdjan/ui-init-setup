package com.ui_init_setup.practiceproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwagLabsLoginPage extends LoadableComponent<SwagLabsLoginPage> {

    private final String baseURL = "https://www.saucedemo.com/";

    private final WebDriver driver;
    private final WebDriverWait wdWait;

    public SwagLabsLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wdWait = new WebDriverWait(driver, Duration.ofMillis(3000));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="user-name") private WebElement inputUserField;
    @FindBy(id ="password") private WebElement inputPassField;
    @FindBy(id ="login-button") private WebElement loginBtn;

    @Override
    protected void load() {
        driver.get(baseURL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(driver.getCurrentUrl().contains(baseURL), "SwagLabs login page is not loaded!");
    }

    private void loginAsValidUser(String username, String password) {
        setUserName(username);
        setPassword(password);
        loginBtn.click();
    }

    private void setUserName(String username) {
        inputUserField.clear();
        inputUserField.sendKeys(username);
    }

    private void setPassword(String password) {
        inputPassField.clear();
        inputPassField.sendKeys(password);
    }

    public SwagLabsInventoryPage loginWithCredentials(String username, String password) {
        loginAsValidUser(username, password);
        return new SwagLabsInventoryPage(driver);
    }
}