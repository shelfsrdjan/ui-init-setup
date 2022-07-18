package com.ui_init_setup.practiceproject.tests;

import com.ui_init_setup.practiceproject.junit.extension.WebDriverSetup;
import com.ui_init_setup.practiceproject.models.Account;
import com.ui_init_setup.practiceproject.pages.ParaBankAccountOverviewPage;
import com.ui_init_setup.practiceproject.pages.ParaBankLoginComponent;
import com.ui_init_setup.practiceproject.utils.APIUtil;
import com.ui_init_setup.practiceproject.utils.Customers;
import com.ui_init_setup.practiceproject.webDriver.ThreadLocalDriver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({WebDriverSetup.class})
class ParaBankAccountTest {

    @Test
    void accountsListed() {
        ParaBankAccountOverviewPage paraBankAccountOverviewPage = new ParaBankLoginComponent(ThreadLocalDriver.getDriver())
                .get()
                .login("john", "demo");

        List<String> actualAccountIdsList = paraBankAccountOverviewPage.getAccounts();

        String customerId = Customers.getCustomerId("john");

        var expectedAccountIdsList =
                APIUtil.getAccounts(customerId)
                        .stream()
                        .map(Account::id)
                        .map(String::valueOf)
                        .collect(Collectors.toList());

        // ASSERT
        assertEquals(expectedAccountIdsList, actualAccountIdsList);
    }
}