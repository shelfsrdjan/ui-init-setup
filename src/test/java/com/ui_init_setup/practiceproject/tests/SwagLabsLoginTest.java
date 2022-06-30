package com.ui_init_setup.practiceproject.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.ui_init_setup.practiceproject.pages.SwagLabsLoginPage;


import static org.junit.jupiter.api.Assertions.assertEquals;


class SwagLabsLoginTest extends BaseTest {

    private SwagLabsLoginPage swagLabsLoginPage;
    private final String expectedURL = "https://www.saucedemo.com/inventory.html";

    @BeforeEach
    public void methodLevelSetup() {
        swagLabsLoginPage = new SwagLabsLoginPage(driver);
        swagLabsLoginPage.get();
    }


    @ParameterizedTest
    @CsvSource({ "standard_user,secret_sauce","problem_user,secret_sauce","performance_glitch_user,secret_sauce"})
    void shouldLoginAs(String username, String password) {
        swagLabsLoginPage.loginWithCredentials(username,password);
        assertEquals(expectedURL, driver.getCurrentUrl());
    }
}