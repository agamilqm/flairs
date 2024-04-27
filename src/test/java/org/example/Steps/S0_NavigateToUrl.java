package org.example.Steps;

import io.cucumber.java.en.*;
import org.example.apiUtils.RestAssuredExtension;

public class S0_NavigateToUrl {
    @Given("User is navigating {string}")
    public void user_navigating(String url) {
        Hooks.driver.navigate().to(url);
    }

    @And("Base url {string} set it up")
    public void base_url_set_it(String baseUrl) {
        RestAssuredExtension.setBaseUrl(baseUrl);
    }

}
