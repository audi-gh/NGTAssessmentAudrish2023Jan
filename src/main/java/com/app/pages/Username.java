package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Username {
    WebDriver driver;

    public Username(WebDriver driver){
        this.driver=driver;

    }
    public  void verifyUsernamefeature() throws Exception {

        driver.get("https://www.myntra.com/login/password");
        String rootFolder= System.getProperty("user.dir");
        System.out.println(rootFolder);
        Properties propObj=new Properties();
        propObj.load(new FileInputStream(rootFolder+"//src//test//credentials.properties"));
        String value1=propObj.getProperty("email");
        String value2=propObj.getProperty("password");
        String url=propObj.getProperty("url");
        driver.findElement(By.xpath("//input[@id=\"mobileNumberPass\"]")).sendKeys(value1);
        driver.findElement(By.xpath("//input[@class=\"form-control has-feedback\"]")).sendKeys(value2);
        driver.findElement(By.xpath("//button[@class=\"btn primary  lg block submitButton\"]")).click();
        Thread.sleep(35000);
        driver.findElement(By.xpath("//button[@class=\"btn primary  lg block submitButton\"]")).click();
        Thread.sleep((5000));
        driver.findElement(By.xpath("//div[@class=\"desktop-user\"]")).click();
       driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/div/div[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/div/div[2]/div[2]/div[1]/a/div[1]")).click();
        String str= driver.findElement((By.xpath("//div[@class=\"account-account\"]/div[2]"))).getText();

        Assert.assertEquals(str,"Audrish Mukherjee");




    }
}
