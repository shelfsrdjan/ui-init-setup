package com.ui_init_setup.practiceproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParaBankAccountOverviewPage extends LoadableComponent<ParaBankAccountOverviewPage> {

    private final WebDriver driver;
    private static final String PARA_BANK_ACCOUNT_OVERVIEW_URL = "https://parabank.parasoft.com/parabank/overview.htm";

    @FindBy(id = "accountTable") private WebElement table;
    @FindBy(xpath = "//tbody//td/a") private WebElement accountRow;
    @FindAll({@FindBy(xpath = "//tbody//td/a")}) private List<WebElement> accountRows;

    public ParaBankAccountOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOf(accountRow));
    }

    public List<String> getAccounts() {
        return accountRows
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Override
    protected void load() {
        driver.get(PARA_BANK_ACCOUNT_OVERVIEW_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(driver.getCurrentUrl().contains(PARA_BANK_ACCOUNT_OVERVIEW_URL), "ParaBank account page is not loaded!");
        assertTrue(table.isDisplayed(), "Table isn't loaded");
    }
}
