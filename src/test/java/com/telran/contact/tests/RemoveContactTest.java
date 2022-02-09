package com.telran.contact.tests;

import com.telran.contact.model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {

    @BeforeMethod

    public void ensurePreconditions() {
        if (!app.getHeader().isSignOutButtonPresent()) {
            app.getUser().logIn();
        }

        int i = (int)((System.currentTimeMillis()/1000) % 3600);
        app.getContact().addContact(new Contact().setName("Mark7").setLastName("Knorr7").setPhone("123456"+ i).setAddress("adam" + i + "@gm.com").setAddress("Berlin").setDescription("No comments"));

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

}
