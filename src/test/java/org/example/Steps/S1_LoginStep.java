package org.example.Steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P1_LoginPage;


public class S1_LoginStep {

    P1_LoginPage loginPage = new P1_LoginPage();

    @When("User enter username {string} and password {string}")
    public void user_enter_username_and_password(String username, String password) {
        loginPage.enterUsernameAndPassword(username,password);
        loginPage.clickLogin();
    }
    @Then("User goes to admin tab")
    public void user_goes_to_admin_tab() {
        loginPage.waitForAdminTabToAppear();
        loginPage.clickAdminTab();
    }
}
