package com.ui_init_setup.practiceproject.pages;

import com.ui_init_setup.practiceproject.constant.BrowserHttpConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwagLabsInventoryPage extends LoadableComponent<SwagLabsInventoryPage> {
    private final WebDriver driver;

    public SwagLabsInventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void load() {
        driver.get(BrowserHttpConstant.SAUCE_INVENTORY_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(driver.getCurrentUrl().contains(BrowserHttpConstant.SAUCE_INVENTORY_URL), "SwagLabs inventory page is not loaded!");
    }
}
