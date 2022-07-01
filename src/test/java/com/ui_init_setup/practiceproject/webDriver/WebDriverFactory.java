package com.ui_init_setup.practiceproject.webDriver;

import com.ui_init_setup.practiceproject.config.propertybased.ConfigurationManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public enum WebDriverFactory {

    CHROME {
        @Override
        public RemoteWebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            return new ChromeDriver(getOptions());
        }

        @Override
        public ChromeOptions getOptions() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(START_MAXIMIZED);
            chromeOptions.addArguments(DISABLE_INFOBARS);
            chromeOptions.addArguments(DISABLE_NOTIFICATIONS);
//            chromeOptions.setHeadless(HEADLESS);
            return chromeOptions;
        }
    }, FIREFOX {
        @Override
        public RemoteWebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            return new FirefoxDriver(getOptions());
        }

        @Override
        public FirefoxOptions getOptions() {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments(START_MAXIMIZED);
//            firefoxOptions.setHeadless(HEADLESS);
            return firefoxOptions;
        }
    };

    private static final String START_MAXIMIZED = "--start-maximized";
    private static final String DISABLE_NOTIFICATIONS = "--disable-notifications";
    private static final String DISABLE_INFOBARS = "--disable-infobars";
//    private static final boolean HEADLESS = ConfigurationManager.getBrowserConfigInstance().headless();

    public abstract RemoteWebDriver createDriver();
    public abstract AbstractDriverOptions<?> getOptions();
}
