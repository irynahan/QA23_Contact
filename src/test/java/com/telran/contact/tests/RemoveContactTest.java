package com.telran.contact.tests;

import com.telran.contact.model.Contact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RemoveContactTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getHeader().isSignOutButtonPresent()) {
            app.getUser().logIn();
        }
        int i = new Random().nextInt(9999999);
        app.getContact().addContact(new Contact().setName("Petya").setLastName("White").setPhone("123456" + i).setEmail("petya" + i + "@gm.com").setAddress("Berlin").setDescription("No comments"));
    }

    @Test
    public void removeContactTest() throws InterruptedException {
        int sizeBefore = app.getContact().sizeOfContacts();
        System.out.println(sizeBefore);
        app.getContact().removeContact();
        Thread.sleep(2000);
        int sizeAfter = app.getContact().sizeOfContacts();
        System.out.println(sizeAfter);
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }

    @Test
    public void removeAllContactTest() {
        int i = new Random().nextInt(9999999);
         app.getContact().addContact(new Contact().setName("SecondRecord").setLastName("White").setPhone("123456" + i).setEmail("secondrecord" + i + "@gm.com").setAddress("Berlin").setDescription("No comments"));


        app.getContact().removeAllContacts();
        Assert.assertTrue(app.getContact().isContactNotHere());
    }

}
