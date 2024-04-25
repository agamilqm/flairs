package org.example.Steps;

import io.cucumber.java.en.*;

public class S0_NavigateToUrl {
    @Given("User is navigating {string}")
    public void user_navigating(String url) {
        Hooks.driver.navigate().to(url);
    }

}
