package com.telran.contact.tests;

import com.telran.contact.framework.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    //@BeforeSuite
    @BeforeMethod
    public void setUp(){
        app.init();
    }

    @BeforeMethod
    public void startTest(Method m){
        logger.info("Start test " + m.getName());
    }

    //@AfterSuite(enabled=false)
    @AfterMethod (enabled=false)
    public void tearDown() {
        app.stop();
    }

    @AfterMethod
    public void stopTest(Method m){
        logger.info("Stop test " + m.getName());
        logger.info("________________________");
    }

}
