package com.telran.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {

        if (!isSignOutButtonPresent()) {
            logIn();
        }
    }

    @Test
    public void addContactPositiveTest() {

        addContact();

        // int i - this variable is used to create a uniq rundom phone number
        //int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        // press the tab ADD in header
        //click(By.cssSelector("a:nth-child(5)"));
        // fill in contact form
       // type(By.cssSelector("input:nth-child(1)"), "Mark4");
        //type(By.cssSelector("input:nth-child(2)"), "Knorr2");
        //type(By.cssSelector("input:nth-child(3)"), "12345" + i);
       // type(By.cssSelector("input:nth-child(4)"), "adam" + i + "@gm.com");
        //type(By.cssSelector("input:nth-child(5)"), "Bern2");
       // type(By.cssSelector("input:nth-child(6)"), "No add comments");
        // press the button Save/Create new contact
       // click(By.cssSelector(".add_form__2rsm2 button"));
        // can be used alternatively, when the button is not displayed
        // version 1 : jumpToFutter(By.cssSelector(".add_form__2rsm2 button"));
        // version 2 : clickWithActions(By.cssSelector(".add_form__2rsm2 button"));
        Assert.assertTrue(isContactCreated("Mark6"));
    }

}
