package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    public void ensurePreconditions() {
        //Login tab not present - ! no true
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            //click on Log out button
            click(By.xpath("//button[contains(.,\"Sign Out\")]"));
        }
    }

    // a[contains(.,'CONTACTS')]

    @Test
    public void loginRegisteredUserTest(){
        //click on login tab
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        // fill login form
        fillRegistrationLoginForm("limmo12@gmail.com", "Zz1234567$");
        // click on LOGIN button
        click(By.xpath("//button[contains(.,' Login')]"));
        // assert user logged in
        //Assert.assertTrue(isElementPresent(By.xpath("//a[contains(.,'CONTACTS')]")));
    }

}
