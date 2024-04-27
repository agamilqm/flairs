package org.example.Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.Pages.P3_AddUserPage;

import java.util.List;

public class S3_AddUserStep {
    P3_AddUserPage addUserPage = new P3_AddUserPage();

    @And("Adding new user")
    public void user_is_adding_new_data(DataTable newUserData) throws InterruptedException
    {
        addUserPage.waitForAddUserTitleToAppear();

        List listOfData = newUserData.asList();


        addUserPage.selectUserRoleFromDropDown(listOfData.get(0).toString());
        addUserPage.fillEmployeeName(listOfData.get(1).toString());
        addUserPage.selectStatusFromDropdown(listOfData.get(2).toString());
        addUserPage.fillUsername(listOfData.get(3).toString());
        addUserPage.fillPasswordAndConfirmPassword(listOfData.get(4).toString());
        addUserPage.clickSave();
    }

    @Then("Assert success message")
    public void assert_success_message (){
        addUserPage.assertionOnSuccessMessage();
    }
}
