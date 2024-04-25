package org.example.Pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P2_AdminPage {
    public String getRecordsFoundFullText (){
        String numberOfRecordsLocator = "//span[@class=\"oxd-text oxd-text--span\" and contains(.,\"Records Found\")]";
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
}
