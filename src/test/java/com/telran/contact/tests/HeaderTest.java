package com.telran.contact.tests;

import com.telran.contact.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase {
    @Test
    public void isLogoPresent() {
        Assert.assertTrue(app.getHeader().isLogoPresent());
    }

    @Test
    public void isHomeTabPresent() {
        Assert.assertTrue(app.getHeader().isHomeTabPresent());
    }

    @Test
    public void isAboutTabElementPresent() {
        Assert.assertTrue(app.getHeader().isAboutTabElementPresent());
    }

}
