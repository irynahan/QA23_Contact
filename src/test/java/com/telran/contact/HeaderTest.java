package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase {

    @Test
    public void isLogoPresent() {
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(.,'PHONEBOOK')]")));
        System.out.println("Test Logo :" + isElementPresent(By.xpath("//h1[contains(.,'PHONEBOOK')]")));
    }

    @Test
    public void isHomeTabPresent() {
        Assert.assertTrue(isElementPresent2(By.xpath("//div/a[contains(.,'HOME')]")));
        System.out.println("Test Home Tab : " + isElementPresent2(By.xpath("//div/a[contains(.,'HOME')]")));
    }

    @Test
    public void isAboutTabElementPresent() {
        Assert.assertTrue(isElementPresent2(By.xpath("//div/a[contains(.,'ABOUT')]")));
        System.out.println("Is tab about Present: " + isElementPresent2(By.xpath("//div/a[contains(.,'ABOUT')]")));
    }
}
