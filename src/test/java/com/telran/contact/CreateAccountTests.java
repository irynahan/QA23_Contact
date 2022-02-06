package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        //Login tab not present - ! no true
        if (!isLoginTabPresent()) {
            //click on Log out button
            clickOnSignOutButton();
        }
    }


    @Test

    public void registrationPositiveTest() {
        //test: click on login tab
        //driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        clickOnLogInTab();
        isRegistrationFormPresent();
        //fill in registration form
        fillRegistrationLoginForm("limmo12@gmail.com", "Zz1234567$");
        // click on Registration button
        clickOnRegistrationButton();
        // check log out button displayed
        isSignOutButtonPresent();
    }

}