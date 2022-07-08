package com.ui_init_setup.practiceproject.tests;

import com.ui_init_setup.practiceproject.constant.BrowserHttpConstant;
import com.ui_init_setup.practiceproject.constant.ErrorMessageConstant;
import com.ui_init_setup.practiceproject.junit.extension.WebDriverSetup;
import com.ui_init_setup.practiceproject.pages.SwagLabsLoginPage;
import com.ui_init_setup.practiceproject.webDriver.ThreadLocalDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({WebDriverSetup.class})
class SwagLabsLoginTest {

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
    @DisplayName("Should not be login with:")
    @ParameterizedTest(name = "{index} => {0}")
    @CsvFileSource(resources = "/data/wronguser.csv", numLinesToSkip = 1)
    void shouldNotLoginWith(String username, String password) {

        SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(ThreadLocalDriver.getDriver())
                .get()
                .loginWithNotValidCredentials(username, password);

        // ASSERT
        assertTrue(swagLabsLoginPage.errorMessIsShown());
        assertEquals(ErrorMessageConstant.ERROR_MESS_CONTAINER,swagLabsLoginPage.getErrorMessage());

    }
}