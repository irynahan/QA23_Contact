package com.telran.contact;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        clickOnLogInTab();
        if (!isRegistrationLoginFormPresent()) {
            //click on Log out button
            clickOnSignOutButton();
        }
    }

    @Test(priority = 1)
    public void loginRegisteredUserTest(){
        // fill in login form
        fillRegistrationLoginForm("limmo12@gmail.com", "Zz1234567$");
        // click on LOGIN button
        clickOnLoginButton();
        // assert user logged in
        Assert.assertTrue(isContactTabPresent());
    }

    @Test(priority = 2)
    public void loginRegisteredUserNegativeTest(){
        // fill in login form
        fillRegistrationLoginForm("limmo12@gmail.com", "Zz1234560$");
        // click on LOGIN button
        clickOnLoginButton();
        // is the alert window present?
        Assert.assertTrue(isAlertPresent());
        //assert 'Login Failed with code 400' displayed
        Assert.assertTrue(isElementPresent2(By.xpath("//div[@class='login_login__3EHKB']/div[contains(.,'Login Failed with code 401')]")));
    }

}
