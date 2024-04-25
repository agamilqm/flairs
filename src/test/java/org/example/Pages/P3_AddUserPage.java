package org.example.Pages;

import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P3_AddUserPage {
    public void waitForAddUserTitleToAppear(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        String addUserTitleLocator = "//*[@class=\"oxd-text oxd-text--h6 orangehrm-main-title\"]";
        wait.until(ExpectedConditions.visibilityOf(Hooks.driver.findElement(By.xpath(addUserTitleLocator))));
    }


}
