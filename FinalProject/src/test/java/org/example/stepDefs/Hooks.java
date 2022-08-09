package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver = null;

    @Before
    public static void OpenBrowser()
    {
        //1- Set System Property
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Mahfouz Sherif\\IdeaProjects\\FinalProject\\drivers\\chromedriver.exe");

        //2- Create new object from webdriver
        driver = new ChromeDriver();

        //3- Configuration
         //3.1- Maximize window
           driver.manage().window().maximize();

         //3.2- Implicit wait
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //4- Navigate to URL
        driver.navigate().to("https://demo.nopcommerce.com/");
    }


    @After
    public static void QuitDriver() throws InterruptedException {
        Thread.sleep(3000);
         driver.quit();
    }
}
