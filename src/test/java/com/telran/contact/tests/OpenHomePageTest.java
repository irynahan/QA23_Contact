package com.telran.contact.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class OpenHomePageTest extends TestBase {

    @Test
    public void openHomePageTest() {
        System.out.println("The page is opened");
        // check if the element on the HomePage is displayed
        //driver.findElement(By.cssSelector("div:nth-child(2)>div>div"));
        // xpath //div[2]/div/div css div:nth-child(2)>div>div
        //isHomeComponentPresent2(div:nth-child(2)>div>div);
        //isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
        app.getHomePage().isHomeComponentPresent();
        // System.out.println("Home Component:" + app.isElementPresent(By.cssSelector("div:nth-child(2)>div>div")));
    }

}
