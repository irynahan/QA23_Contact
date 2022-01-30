package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
//preconditions: user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        //Login tab not present - ! no true
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            //click on Log out button
            click(By.xpath("//button[contains(.,\"Sign Out\")]"));
        }
    }

    @Test

    public void registrationPositiveTest(){
        //test: click on login tab
        //driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        isRegistrationFormPresent();
        //fill in registration form
        fillRegistrationLoginForm("limmo12@gmail.com", "Zz1234567$");
        // click on Registration button
        click(By.xpath("//button[contains(.,'Registration')]"));
        // check log out button displayed
        isSignOutButtonPresent();
    }


}
