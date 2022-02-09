package com.telran.contact.tests;

import com.telran.contact.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getUser().clickOnLogInTab();
        if (!app.getUser().isRegistrationLoginFormPresent()) {
            //click on Log out button
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test(priority = 1)
    public void loginRegisteredUserTest(){
        // fill in login form
        app.getUser().fillRegistrationLoginForm(new User().setEmail("limmo12@gmail.com").setPassword("Zz1234567$"));
        // click on LOGIN button
        app.getUser().clickOnLoginButton();
        // assert user logged in
        Assert.assertTrue(app.getHeader().isContactTabPresent());
    }

    @Test(priority = 2)
    public void loginRegisteredUserNegativeTest(){
        // fill in login form
        app.getUser().fillRegistrationLoginForm(new User().setEmail("limmo12@gmail.com").setPassword("Zz1234560$"));
        // click on LOGIN button
        app.getUser().clickOnLoginButton();
        // is the alert window present?
        Assert.assertTrue(app.getUser().isAlertPresent());
        //assert 'Login Failed with code 400' displayed
        Assert.assertTrue(app.getUser().isElementPresent2(By.xpath("//div[@class='login_login__3EHKB']/div[contains(.,'Login Failed with code 401')]")));
    }

}
