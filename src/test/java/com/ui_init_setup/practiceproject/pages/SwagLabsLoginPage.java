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

public class SwagLabsLoginPage extends LoadableComponent<SwagLabsLoginPage> {

    private final WebDriver driver;
    private final WebDriverWait wdWait;

    @FindBy(id = "user-name") private WebElement inputUserField;
    @FindBy(id = "password") private WebElement inputPassField;
    @FindBy(id = "login-button") private WebElement loginBtn;

    public SwagLabsLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wdWait = new WebDriverWait(driver, Duration.ofMillis(3000));
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get(BrowserHttpConstant.SAUCE_DEMO_BASE_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(driver.getCurrentUrl().contains(BrowserHttpConstant.SAUCE_DEMO_BASE_URL), "SwagLabs login page is not loaded!");
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