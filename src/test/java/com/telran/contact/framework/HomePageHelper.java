package com.telran.contact.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends HelperBase {


    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public void isHomeComponentPresent() {
        isElementPresent2(By.cssSelector("div:nth-child(2) > div > div"));
    }

    //public boolean isHomeComponentPresent1(){
        //return app.driver.findElements(By.cssSelector("div:nth-child(2)>div>div")).size()>0;
   // }

    //public boolean isHomeComponentPresent2(){
        //try{
           // app.driver.findElement(By.cssSelector("div:nth-child(2)>div>div"));
            //return true;
        //} catch (NoSuchElementException e) {
            //return false;
        //}
    //}

}
