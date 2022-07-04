package com.ui_init_setup.practiceproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwagLabsInventoryPage extends LoadableComponent<SwagLabsInventoryPage> {


    private final String inventoryURL = "https://www.saucedemo.com/inventory.html";

    private final WebDriver driver;

    public SwagLabsInventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void load() {
        driver.get(inventoryURL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(driver.getCurrentUrl().contains(inventoryURL), "SwagLabs inventory page is not loaded!");
    }
}
