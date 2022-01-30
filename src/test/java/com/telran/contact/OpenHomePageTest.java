package com.telran.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenHomePageTest extends TestBase {

    @Test
    public void openHomePageTest() {
        System.out.println("The page is opened");
        // check if the element on the HomePage is displayed
        //driver.findElement(By.cssSelector("div:nth-child(2)>div>div"));
        // xpath //div[2]/div/div css div:nth-child(2)>div>div
        //isHomeComponentPresent2(div:nth-child(2)>div>div);
        isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
        System.out.println("Home Component:" + isElementPresent(By.cssSelector("div:nth-child(2)>div>div")));
    }

    public boolean isHomeComponentPresent(){
       return driver.findElements(By.cssSelector("div:nth-child(2)>div>div")).size()>0;
    }

    public boolean isHomeComponentPresent2(){
       try{
           driver.findElement(By.cssSelector("div:nth-child(2)>div>div"));
           return true;
       } catch (NoSuchElementException e) {
           return false;
       }
    }
}
