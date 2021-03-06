package com.ui_init_setup.practiceproject.utils;

import com.ui_init_setup.practiceproject.models.Account;
import io.restassured.http.Header;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class APIUtil {

    private static final String ENDPOINT = "http://parabank.parasoft.com/parabank/services/bank/";
    public static final String GET_ACCOUNTS = ENDPOINT + "customers/%s/accounts";

    public static List<Account> getAccounts(String customerId){
        return Arrays.asList(given()
                .header(new Header("Accept", "application/json"))
                .get(format(GET_ACCOUNTS, customerId))
                .as(Account[].class));
    }

    public static List<String> getAccountIds_mocked(){
        return List.of("13344", "13455", "13566", "14010");
    }

    public String getAccounts_mocked(){
        return """
                [
                  {
                    "id": 13344,
                    "customerId": 12212,
                    "type": "CHECKING",
                    "balance": 3821.93
                  },
                  {
                    "id": 13455,
                    "customerId": 12212,
                    "type": "LOAN",
                    "balance": 989
                  }
                ]
                """;
    }
}