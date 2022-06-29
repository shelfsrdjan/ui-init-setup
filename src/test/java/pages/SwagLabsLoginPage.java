package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabsLoginPage {

    @FindBy(id ="user-name") WebElement inputUserField;
    @FindBy(id ="password") WebElement inputPassField;
    @FindBy(id ="login-button") WebElement loginBtn;

    WebDriver driver;
    WebDriverWait wdWait;

    public SwagLabsLoginPage(WebDriver driver, WebDriverWait wdWait)
    {
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver,this);
    }

    public void loginAsStandardUser(String username, String password) {
        this.inputUserField.clear();
        this.inputUserField.sendKeys(username);
        this.inputPassField.clear();
        this.inputPassField.sendKeys(password);
        loginBtn.click();
    }
    public void fetchCredentialsForStandardUser() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginAsStandardUser(username, password);
        wdWait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
    }
}
