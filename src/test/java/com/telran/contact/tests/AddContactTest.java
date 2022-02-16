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
        app.getContact().addContact(new Contact().setName("Mark7").setLastName("Knorr7").setPhone("123456"+ i).setEmail("adam" + i + "@gm.com").setAddress("Berlin").setDescription("No comments"));
        Assert.assertTrue(app.getContact().isContactCreated("Mark7"));
        app.getContact().removeContact();
    }

    @Test
    public void addContactNegativeWithoutEmailTest() {
        int i = (int)((System.currentTimeMillis()/1000) % 3600);
        app.getContact().addContact(new Contact().setName("Mark7").setLastName("Knorr7").setPhone("123456"+ i).setAddress("Berlin").setDescription("No comments"));
        Assert.assertTrue(app.getContact().isSaveBtnPresent());
    }

}
