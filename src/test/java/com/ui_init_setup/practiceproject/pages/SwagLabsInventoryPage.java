package com.ui_init_setup.practiceproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwagLabsInventoryPage extends LoadableComponent<SwagLabsInventoryPage> {

    private final WebDriver driver;
    private static final String SAUCE_INVENTORY_URL = "https://www.saucedemo.com/inventory.html";

    public SwagLabsInventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean currentUrlIsDisplayedCorrectly() {
        return driver.getCurrentUrl().equals(SAUCE_INVENTORY_URL);
    }

    @Override
    protected void load() {
        driver.get(SAUCE_INVENTORY_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(driver.getCurrentUrl().contains(SAUCE_INVENTORY_URL), "SwagLabs inventory page is not loaded!");
    }
}
