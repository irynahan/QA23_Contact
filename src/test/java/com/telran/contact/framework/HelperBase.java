package com.telran.contact.framework;

import com.telran.contact.model.Contact;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelperBase {
    //static WebDriver driver;
    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    public boolean isElementPresent2(By locator){
        try{
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void type(By locator, String text) {
        if(text != null) {
            driver.findElement(locator).click();
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
        if(alert == null) {
            return false;
        } else {
            driver.switchTo().alert();
            // accebt = click the button OK
            alert.accept();
            return true;
        }
    }

    public void jumpToFooter(By  locator) {
        driver.findElement(locator).sendKeys(Keys.CONTROL, Keys.END);
    }

    public void clickWithActions(By save) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(save);
        actions.moveToElement(element).build().perform();
        element.click();
    }

    public void isElementVisible(By locator, int time){
        new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public boolean isTextContainsInElement(By locator, int time, String text) {
        return new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElement(driver.findElement(locator), text));
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
