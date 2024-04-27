package org.example.Pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import java.util.List;

import java.time.Duration;

public class P3_AddUserPage {
        private WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));

    public void waitForAddUserTitleToAppear(){
        String addUserTitleLocator = "//*[@class=\"oxd-text oxd-text--h6 orangehrm-main-title\"]";
        wait.until(ExpectedConditions.visibilityOf(Hooks.driver.findElement(By.xpath(addUserTitleLocator))));
    }
    public void selectUserRoleFromDropDown(String item){
        clickUserRoleDropdownList();
        waitForDropdownToBeVisible();
        selectFromDropdownOptions(item);
    }
    public void fillEmployeeName(String name){
        String employeeNameLocator = "//*[@class=\"oxd-autocomplete-text-input--before\"]/following-sibling::input";

        WebElement employeeNameElement =Hooks.driver.findElement(By.xpath(employeeNameLocator));
        employeeNameElement.click();
        employeeNameElement.sendKeys(name);

        String autoCompleteDropdownLocator = String.format("//*[@class=\"oxd-autocomplete-option\" and contains(.,\"%s\")]",name);
        WebElement autoCompleteElement = Hooks.driver.findElement(By.xpath(autoCompleteDropdownLocator));
        wait.until(ExpectedConditions.visibilityOf(autoCompleteElement));
        autoCompleteElement.click();

    }
    public void selectStatusFromDropdown (String item){
        clickStatusDropdownList();
        waitForDropdownToBeVisible();
        selectFromDropdownOptions(item);
    }

    public void fillUsername(String username){
        String usernameLocator = "//label[contains(text(),\"Username\")]/parent::div/parent::div//*[contains(@class,\"oxd-input oxd-input\")]";

        WebElement userNameElement = Hooks.driver.findElement(By.xpath(usernameLocator));
        userNameElement.click();
        userNameElement.sendKeys(username);
    }
    public void fillPasswordAndConfirmPassword(String password){
        String pwAndConfirmPwLocator = "//label[contains(text(),\"Password\")]/parent::div/parent::div//*[contains(@class,\"oxd-input oxd-input\")]";
        List <WebElement> listOfLocators = Hooks.driver.findElements(By.xpath(pwAndConfirmPwLocator));
        listOfLocators.get(0).click();
        listOfLocators.get(0).sendKeys(password);
        listOfLocators.get(1).click();
        listOfLocators.get(1).sendKeys(password);
    }

    public void clickSave(){
        String saveButtonLocator = "//*[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]";
        Hooks.driver.findElement(By.xpath(saveButtonLocator)).click();
    }

    public void  assertionOnSuccessMessage(){
        wait.until(ExpectedConditions.visibilityOf(Hooks.driver.findElement(By.id("oxd-toaster_1"))));
    }
    private void clickUserRoleDropdownList(){
        String userRoleLocator = "//label[contains(text(),\"User Role\")]/parent::div/parent::div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//*[@class=\"oxd-select-wrapper\"]";
        Hooks.driver.findElement(By.xpath(userRoleLocator)).click();
    }

    private void waitForDropdownToBeVisible(){
        WebElement dropDownLocator = Hooks.driver.findElement(By.xpath("//*[@class=\"oxd-select-dropdown --positon-bottom\"]"));
        wait.until(ExpectedConditions.visibilityOf(dropDownLocator));
    }

    private void selectFromDropdownOptions(String item){
        String itemLocator = String.format("//*[@class=\"oxd-select-option\"]//*[contains(text(),\"%s\")]",item);
        Hooks.driver.findElement(By.xpath(itemLocator)).click();
    }


    private void clickStatusDropdownList(){
        String statusDropdownLocator = "//label[contains(text(),\"Status\")]/parent::div/parent::div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//*[@class=\"oxd-select-wrapper\"]";
        Hooks.driver.findElement(By.xpath(statusDropdownLocator)).click();
    }



}
