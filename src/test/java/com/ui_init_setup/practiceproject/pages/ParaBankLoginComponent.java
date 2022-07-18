package com.ui_init_setup.practiceproject.pages;

import com.ui_init_setup.practiceproject.constant.BrowserHttpConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParaBankLoginComponent extends LoadableComponent<ParaBankLoginComponent> {

    private final WebDriver driver;
    private final WebDriverWait wdWait;

    @FindBy(name = "username") private WebElement usernameField;
    @FindBy(name = "password") private WebElement passwordField;
    @FindBy(css = " .login .button") private WebElement loginBtn;

    public ParaBankLoginComponent(WebDriver driver) {
        this.driver = driver;
        this.wdWait = new WebDriverWait(driver, Duration.ofMillis(3000));
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get(BrowserHttpConstant.PARA_BANK_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(driver.getCurrentUrl().contains(BrowserHttpConstant.PARA_BANK_URL), "ParaBank login page is not loaded!");
        assertTrue(usernameField.isDisplayed(), "Input username field isn't loaded");
        assertTrue(passwordField.isDisplayed(), "Input password field isn't loaded");
        assertTrue(loginBtn.isDisplayed(), "Login button isn't loaded");
    }

    public ParaBankAccountOverviewPage login(String username, String password) {
        loginAs(username, password);
        return new ParaBankAccountOverviewPage(driver);
    }

    private void loginAs(String username, String password) {
        setUserName(username);
        setPassword(password);
        loginBtn.click();
    }

    private void setUserName(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    private void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
}