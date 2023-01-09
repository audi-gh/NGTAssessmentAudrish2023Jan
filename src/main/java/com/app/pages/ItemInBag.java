package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;

public class ItemInBag {
    WebDriver driver;

    public ItemInBag(WebDriver driver){
        this.driver=driver;

    }

    public  void verifyItemInBagfeature() throws InterruptedException {


        driver.get("https://www.myntra.com/");
        driver.findElement(By.xpath("//input[@class=\"desktop-searchBar\"]")).sendKeys("Watch");
        driver.findElement(By.xpath("//a[@class=\"desktop-submit\"]"));
        Actions action=new  Actions(driver);
        Thread.sleep(2000);

        WebElement searchbutton= driver.findElement(By.xpath("//a[@class=\"desktop-submit\"]"));
        action.moveToElement(searchbutton);
        action.click().build().perform();
        Thread.sleep(2000);




        WebElement pricebutton=driver.findElement(By.xpath("(//div[@class='product-price'])[1]"));
        action.moveToElement(pricebutton);
        action.click().build().perform();

        ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));






        WebElement addToBagButton= driver.findElement(By.cssSelector("div.pdp-add-to-bag"));
        action.moveToElement(addToBagButton);
        action.click().build().perform();
        Thread.sleep(2000);

        WebElement checkcart= driver.findElement(By.xpath("//header/div[2]/div[2]/a[2]/span[2]"));
        Thread.sleep(2000);
        if(checkcart.getText().contains("1")){
            Assert.assertTrue(true);

        }
        Thread.sleep(3000);

    }







}
