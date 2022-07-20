package com.ui_init_setup.practiceproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParaBankAccountOverviewPage extends LoadableComponent<ParaBankAccountOverviewPage> {

    private final WebDriver driver;
    private final WebDriverWait wdWait;
    public static final String PARA_BANK_ACCOUNT_OVERVIEW_URL = "https://parabank.parasoft.com/parabank/overview.htm";

    @FindBy(id = "accountTable") private WebElement table;
    @FindBy(css = "#accountTable tr[ng-repeat='account in accounts'] td:not(.ng-binding)") private WebElement accountColumn;
//    @FindBy(xpath = "//a[contains(@href,'activity.htm')]") private WebElement accountColumn;

    public ParaBankAccountOverviewPage(WebDriver driver) {
        this.driver = driver;
        this.wdWait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wdWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("accountTable"))));
    }

    public List<String> getAccounts() {
//        return driver.findElements(By.xpath("//a[contains(@href,'activity.htm')]"))
        return driver.findElements(By.cssSelector("#accountTable tr[ng-repeat='account in accounts'] td:not(.ng-binding)"))
//        return driver.findElements((By) accountColumn)
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
        assertTrue(table.isDisplayed(),"Table isn't loaded");
        assertTrue(accountColumn.isDisplayed(),"Account Column isn't loaded");
    }
}
