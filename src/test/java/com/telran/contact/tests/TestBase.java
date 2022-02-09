package com.telran.contact.tests;

import com.telran.contact.framework.ApplicationManager;
import org.testng.annotations.*;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    //@BeforeSuite
    @BeforeMethod
    public void setUp(){
        app.init();
    }

    //@AfterSuite(enabled=false)
    @AfterMethod (enabled=false)
    public void tearDown() {
        app.stop();
    }
    
}
