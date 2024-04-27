package org.example.Pages;

import io.cucumber.messages.types.Hook;
import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P1_LoginPage {
    private String adminTabLocator = "//li//a[contains(.,\"Admin\")]";
    public void enterUsernameAndPassword(String username , String password){

        String usernameLocator = "username";
        String passwordLocator = "password";

        Hooks.driver.findElement(By.name(usernameLocator)).sendKeys(username);
        Hooks.driver.findElement(By.name(passwordLocator)).sendKeys(password);
    }

    public void clickLogin(){

        String loginClassNameLocator = "orangehrm-login-button";

        Hooks.driver.findElement(By.className(loginClassNameLocator)).click();
    }
    public void waitForAdminTabToAppear(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(Hooks.driver.findElement(By.xpath(adminTabLocator))));
    }
    public void clickAdminTab(){
        Hooks.driver.findElement((By.xpath(adminTabLocator))).click();

    }
}
