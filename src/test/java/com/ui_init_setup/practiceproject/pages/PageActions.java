package com.ui_init_setup.practiceproject.pages;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@AllArgsConstructor
class PageActions {

    private final WebDriver driver;

    public void clearAndType(WebElement element,String text) {
        element.clear();
        element.sendKeys(text);
    }
}
