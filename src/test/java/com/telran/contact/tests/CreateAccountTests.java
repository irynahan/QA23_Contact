package com.telran.contact.tests;

import com.telran.contact.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        //Login tab not present - ! no true
        if (!app.getHeader().isLoginTabPresent()) {
            //click on Log out button
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test(enabled = false)

    public void registrationPositiveTest() {
        //test: click on login tab
        //driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        app.getUser().clickOnLogInTab();
        app.getUser().isRegistrationFormPresent();
        //fill in registration form
        app.getUser().fillRegistrationLoginForm(new User().setEmail("limmo22@gmail.com").setPassword("Zz1234567$"));
        // click on Registration button
        app.getUser().clickOnRegistrationButton();
        // check log out button displayed
        app.getHeader().isSignOutButtonPresent();
    }

    @Test
    public void registrationNegativeWithoutPasswordTest() {
        //test: click on login tab
        //driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        app.getUser().clickOnLogInTab();
        app.getUser().isRegistrationFormPresent();
        //fill in registration form
        app.getUser().fillRegistrationLoginForm(new User ().setEmail("limmo12@gmail.com"));
        // click on Registration button
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}