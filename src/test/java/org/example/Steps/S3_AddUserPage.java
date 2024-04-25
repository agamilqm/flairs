package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.Pages.P3_AddUserPage;

public class S3_AddUserPage {
    P3_AddUserPage addUserPage = new P3_AddUserPage();

    @And("User is adding new data with username {string}")
    public void user_is_adding_new_data(String newUsername) {
        addUserPage.waitForAddUserTitleToAppear();
    }
}
