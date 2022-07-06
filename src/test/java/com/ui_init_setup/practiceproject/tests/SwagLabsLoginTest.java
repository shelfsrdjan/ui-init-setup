package com.ui_init_setup.practiceproject.tests;

import com.ui_init_setup.practiceproject.constant.BrowserHttpConstant;
import com.ui_init_setup.practiceproject.junit.annotations.WIP;
import com.ui_init_setup.practiceproject.webDriver.SupportedWebDriverProvider;
import com.ui_init_setup.practiceproject.webDriver.ThreadLocalDriver;

import com.ui_init_setup.practiceproject.pages.SwagLabsLoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwagLabsLoginTest {

    @BeforeEach
    void setupWebDrivers() {
        WebDriver driver = SupportedWebDriverProvider.getSupportedBrowser();
        ThreadLocalDriver.addDriver(driver);
    }

    @WIP
    @DisplayName("Should be login as:")
    @ParameterizedTest(name = "{index} => {0}")
    @CsvFileSource(resources = "/data/user.csv", numLinesToSkip = 1)
    void shouldLoginAs(String username, String password) {

        new SwagLabsLoginPage(ThreadLocalDriver.getDriver())
                .get()
                .loginWithCredentials(username, password);

        // ASSERT
        assertEquals(BrowserHttpConstant.SAUCE_INVENTORY_URL, ThreadLocalDriver.getDriver().getCurrentUrl());
    }
}