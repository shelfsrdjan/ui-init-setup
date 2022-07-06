package com.ui_init_setup.practiceproject.config.propertybased;

import org.aeonbits.owner.Config;

import static com.ui_init_setup.practiceproject.constant.PropertyNameConstant.TARGET_ENV;

@Config.Sources("file:${user.dir}/src/test/resources/properties/browser.properties")
@Config.LoadPolicy(Config.LoadType.MERGE)
public interface BrowserConfig extends Config {

    @Key("${" + TARGET_ENV + "}.headless")
    @DefaultValue("FALSE")
    Boolean headless();

    @Key("${" + TARGET_ENV + "}.browser")
    @DefaultValue("CHROME")
    String defaultBrowser();
}