package com.telran.contact.tests;

import com.telran.contact.model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {

        if (!app.getHeader().isSignOutButtonPresent()) {
            app.getUser().logIn();
        }
    }

    @Test
    public void addContactPositiveTest() {

        int i = (int)((System.currentTimeMillis()/1000) % 3600);
        Contact c = new Contact();
        app.getContact().addContact(new Contact().setName("Mark7").setLastName("Knorr7").setPhone("123456"+ i).setAddress("adam" + i + "@gm.com").setAddress("Berlin").setDescription("No comments"));

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
        Assert.assertTrue(app.getContact().isContactCreated("Mark7"));
    }

}
