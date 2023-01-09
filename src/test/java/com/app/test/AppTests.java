package com.app.test;

import com.app.pages.ItemInBag;
import com.app.pages.Username;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

public class AppTests {

    WebDriver driver;
    ItemInBag itemInBag;
    Username username;
    @BeforeMethod
    public void setup() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        itemInBag=new ItemInBag(driver);
        username=new Username(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }


    @Test
    public void verifyItemInBag() throws InterruptedException {

       itemInBag.verifyItemInBagfeature();


    }
    @Test
    public void verifyUsername() throws Exception {
        username.verifyUsernamefeature();

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();

   }
}
