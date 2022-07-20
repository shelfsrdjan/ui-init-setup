package com.ui_init_setup.practiceproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParaBankLoginComponent extends LoadableComponent<ParaBankLoginComponent> {

    private final WebDriver driver;
    private final PageActions paraBankLoginPageActions;
    public static final String PARA_BANK_URL = "https://parabank.parasoft.com/parabank/index.htm";

    @FindBy(name = "username") private WebElement usernameField;
    @FindBy(name = "password") private WebElement passwordField;
    @FindBy(css = " .login .button") private WebElement loginBtn;

    public ParaBankLoginComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        paraBankLoginPageActions = new PageActions(driver);
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
        paraBankLoginPageActions.clearAndType(usernameField, username);
    }

    private void setPassword(String password) {
        paraBankLoginPageActions.clearAndType(passwordField, password);
    }

    @Override
    protected void load() {
        driver.get(PARA_BANK_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(driver.getCurrentUrl().contains(PARA_BANK_URL), "ParaBank login page is not loaded!");
        assertTrue(usernameField.isDisplayed(), "Input username field isn't loaded");
        assertTrue(passwordField.isDisplayed(), "Input password field isn't loaded");
        assertTrue(loginBtn.isDisplayed(), "Login button isn't loaded");
    }
}