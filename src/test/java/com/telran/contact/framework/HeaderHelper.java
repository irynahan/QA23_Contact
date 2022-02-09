package com.telran.contact.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends HelperBase {
    public HeaderHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isAboutTabElementPresent(){
        return isElementPresent2(By.xpath("//div/a[contains(.,'ABOUT')]"));
    }

    public boolean isHomeTabPresent(){
        return isElementPresent2(By.xpath("//div/a[contains(.,'HOME')]"));
    }

    public boolean isLogoPresent() {
        return isElementPresent(By.xpath("//h1[contains(.,'PHONEBOOK')]"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[contains(.,\"Sign Out\")]"));
    }

    public boolean isLoginTabPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,\"Sign Out\")]"));
    }

    public boolean isContactTabPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'CONTACTS')]"));
    }
}
