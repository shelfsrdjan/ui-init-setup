package com.ui_init_setup.practiceproject.config.yamlbased;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class YamlConfigModel {
    @JsonProperty("environment-profiles") private ArrayList<Profile> profiles;

    @Getter
    public static class Profile {
        private String name;
        @JsonProperty("be-url") private String beUrl;
        @JsonProperty("gql-url") private String gqlUrl;
    }
}
