package org.example.Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.apiUtils.RestAssuredExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Hooks {
    public static WebDriver driver = null ;
    @Before
    public static void testSetup ()
    {
//        WebDriverManager.chromedriver().clearDriverCache().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
    }
    @After
    public static void closeBrowser() throws InterruptedException
    {
//        Thread.sleep(2000);
//        driver.quit();
    }
}
