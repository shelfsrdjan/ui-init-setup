package com.ui_init_setup.practiceproject.config.propertybased;

import org.aeonbits.owner.Config;

@Config.Sources("file:${user.dir}/src/test/resources/browser.properties")
@Config.LoadPolicy(Config.LoadType.MERGE)
public interface BrowserConfig extends Config {

    @Key("$.headless")
    Boolean headless();
}