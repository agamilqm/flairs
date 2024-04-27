package org.example.Steps;

import io.cucumber.java.en.*;
import org.example.Pages.P2_AdminPage;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class S2_AdminStep {
    P2_AdminPage adminPage = new P2_AdminPage();
    private Integer recordsBeforeAdd ;
    private Integer recordsAfterAdd ;

    private Integer recordBeforeDelete;
    private Integer recordsAfterDelete;
    @Given("The number of records found")
    public void the_number_of_records_found() {

        String recordsFoundString = adminPage.getRecordsFoundFullText();
        recordsBeforeAdd = adminPage.getRecordsFoundInteger(recordsFoundString);
        Integer numberOfElements =  adminPage.getAllRecordsFoundUsingElements();

        Assertion hardAssertion = new Assertion();
        hardAssertion.assertEquals(recordsBeforeAdd,numberOfElements);
    }

    @And("verify number of records increased by {int}")
    public void verify_number_of_records_increased_by(Integer increaseValue) {
        adminPage.waitForFoundRecord();
        String recordsFoundString = adminPage.getRecordsFoundFullText();
        recordsAfterAdd = adminPage.getRecordsFoundInteger(recordsFoundString);
        Integer numberOfElements =  adminPage.getAllRecordsFoundUsingElements();

        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(recordsAfterAdd,numberOfElements);
        Integer expectedResultAfterAdd = recordsBeforeAdd+increaseValue;
        softAssertion.assertEquals(recordsAfterAdd,expectedResultAfterAdd);

        softAssertion.assertAll();
    }

    @When("User Navigating to Add new user Page")
    public void user_is_navigating_to_addPage(){
        adminPage.clickAddNewUser();
    }

    @Given("the username {string} search for it")
    public void search_for_username(String username){
        String recordsFoundString = adminPage.getRecordsFoundFullText();
        recordBeforeDelete = adminPage.getRecordsFoundInteger(recordsFoundString);

        adminPage.fillSearchOfUsername(username);
        adminPage.clickSearchButton();
    }
    @Given("User is deleting username {string} and resetting search")
    public void user_is_deleting_specific_record_and_resetting_search(String username){
        adminPage.clickDeleteUser(username);
        adminPage.clickYesDeleteButton();
        adminPage.waitForSuccessMessage();
        adminPage.clickResetSearch();
    }
    @Given("Verify number of records decreased by {int}")
    public void verify_number_of_records_decreased(Integer decreaseValue){
        adminPage.waitForFoundRecord();
        String recordsFoundString = adminPage.getRecordsFoundFullText();
        recordsAfterDelete = adminPage.getRecordsFoundInteger(recordsFoundString);
        Integer numberOfElements =  adminPage.getAllRecordsFoundUsingElements();

        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(recordsAfterDelete,numberOfElements);
        Integer expectedResultAfterAdd = recordBeforeDelete-decreaseValue;
        softAssertion.assertEquals(recordsAfterDelete,expectedResultAfterAdd);

        softAssertion.assertAll();
    }


}
