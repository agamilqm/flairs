package org.example.Pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P2_AdminPage {
        private WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        private String numberOfRecordsLocator = "//span[@class=\"oxd-text oxd-text--span\" and contains(.,\"Records Found\")]";

    public void waitForFoundRecord(){
        wait.until(ExpectedConditions.visibilityOf(Hooks.driver.findElement(By.xpath(numberOfRecordsLocator))));
    }
    public String getRecordsFoundFullText (){
        String numberOfRecords = Hooks.driver.findElement(By.xpath(numberOfRecordsLocator)).getText();
        System.out.println(numberOfRecords);
        return numberOfRecords;
    }

    public Integer getRecordsFoundInteger (String recordsFoundString){
        String regEx = "\\(\\s*(\\d+)\\s*\\)";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(recordsFoundString);
        if (matcher.find()) {
            Integer recordValueInt = Integer.parseInt(matcher.group(1));
            System.out.println("The number inside Records Text is: " + recordValueInt);
            return recordValueInt;
        }
        return 0;
    }

    public Integer getAllRecordsFoundUsingElements (){

        String allElementsClasses = "oxd-table-card";
        Integer numberOfElements = Hooks.driver.findElements(By.className(allElementsClasses)).size();
        System.out.println("Number Of Elements Found is "+numberOfElements);
        return numberOfElements;
    }

    public void clickAddNewUser(){
        String addButtonLocator = "//*[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]";
        Hooks.driver.findElement(By.xpath(addButtonLocator)).click();

    }


    public void fillSearchOfUsername (String username){
        String usernameSearchLocator = "//label[contains(text(),\"Username\")]/parent::div/parent::div//input[@class=\"oxd-input oxd-input--active\"]";
        WebElement userNameSearchElement = Hooks.driver.findElement(By.xpath(usernameSearchLocator));
        userNameSearchElement.click();
        userNameSearchElement.sendKeys(username);
    }
    public void clickSearchButton (){
        String searchButtonLocator = "//*[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]";
        Hooks.driver.findElement(By.xpath(searchButtonLocator)).click();
    }
    public void clickDeleteUser(String username){
        String deleteLocatorUsingUsername = String.format("//*[@class=\"oxd-table-cell oxd-padding-cell\" and contains(.,\"new user\")]/following-sibling::div//*[@class=\"oxd-icon bi-trash\"]",username);
        WebElement deleteElement = Hooks.driver.findElement(By.xpath(deleteLocatorUsingUsername));
        wait.until(ExpectedConditions.visibilityOf(deleteElement));
        deleteElement.click();
    }
    public void clickYesDeleteButton(){
        String yesDeleteButtonLocator = "//button[@class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]";
        WebElement yesDeleteButtonElement = Hooks.driver.findElement(By.xpath(yesDeleteButtonLocator));
        wait.until(ExpectedConditions.visibilityOf(yesDeleteButtonElement));
        yesDeleteButtonElement.click();
    }
    public void waitForSuccessMessage(){
        wait.until(ExpectedConditions.visibilityOf(Hooks.driver.findElement(By.id("oxd-toaster_1"))));
    }
    public void clickResetSearch(){
        String resetButtonLocator = "//*[@class=\"oxd-button oxd-button--medium oxd-button--ghost\"]";
        Hooks.driver.findElement(By.xpath(resetButtonLocator)).click();
    }
}
