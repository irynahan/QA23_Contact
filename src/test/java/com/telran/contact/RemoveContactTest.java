package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {

    @BeforeMethod

    public void ensurePreconditions() {
        if (!isSignOutButtonPresent()) {
            logIn();
        }
        addContact();
    }

    @Test
    public void removeContactTest() throws InterruptedException {
        int sizeBefore = sizeOfContacts();
        System.out.println(sizeBefore);
        removeContact();
        Thread.sleep(2000);
        int sizeAfter = sizeOfContacts();
        System.out.println(sizeAfter);
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }

}
