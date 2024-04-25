package org.example.Steps;

import io.cucumber.java.en.*;
import org.example.Pages.P2_AdminPage;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class S2_AdminStep {
    P2_AdminPage adminPage = new P2_AdminPage();
    public Integer recordsBeforeAdd ;
    public Integer recordsAfterAdd ;

    @Given("The number of records found")
    public void the_number_of_records_found() {

        String recordsFoundString = adminPage.getRecordsFoundFullText();
        recordsBeforeAdd = adminPage.getRecordsFoundInteger(recordsFoundString);
        Integer numberOfElements =  adminPage.getAllRecordsFoundUsingElements();

        Assertion hardAssertion = new Assertion();
        hardAssertion.assertEquals(recordsBeforeAdd,numberOfElements);
    }

    @Then("verify number of records increased by {int}")
    public void verify_number_of_records_increased_by(Integer increaseValue) {
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

}
