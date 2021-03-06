package com.ui_init_setup.practiceproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwagLabsLoginPage extends LoadableComponent<SwagLabsLoginPage> {

    private final WebDriver driver;
    private final WebDriverWait wdWait;
    private final PageActions pageActions;
    public static final String SAUCE_DEMO_BASE_URL = "https://www.saucedemo.com/";

    @FindBy(id = "user-name") private WebElement inputUserField;
    @FindBy(id = "password") private WebElement inputPassField;
    @FindBy(id = "login-button") private WebElement loginBtn;
    @FindBy(className = "error-message-container") private WebElement errorMessage;

    public SwagLabsLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wdWait = new WebDriverWait(driver, Duration.ofMillis(3000));
        PageFactory.initElements(driver, this);
        pageActions = new PageActions(driver);
    }

    public SwagLabsInventoryPage loginWithCredentials(String username, String password) {
        loginAs(username, password);
        return new SwagLabsInventoryPage(driver);
    }

    public SwagLabsLoginPage loginWithNotValidCredentials(String username, String password) {
        loginAs(username, password);
        return this;
    }

    private void loginAs(String username, String password) {
        setUserName(username);
        setPassword(password);
        loginBtn.click();
    }

    private void setUserName(String username) {
        pageActions.clearAndType(inputUserField, username);
    }

    private void setPassword(String password) {
        pageActions.clearAndType(inputPassField, password);
    }

    public String getErrorMessage() {
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-container")));
        return errorMessage.getText();
    }

    public boolean errorMessIsShown() {
        return errorMessage.isDisplayed();
    }

    @Override
    protected void load() {
        driver.get(SAUCE_DEMO_BASE_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(driver.getCurrentUrl().contains(SAUCE_DEMO_BASE_URL), "SwagLabs login page is not loaded!");
        assertTrue(inputUserField.isDisplayed(), "Input username field isn't loaded");
        assertTrue(inputPassField.isDisplayed(), "Input password field isn't loaded");
        assertTrue(loginBtn.isDisplayed(), "Login button isn't loaded");
    }
}