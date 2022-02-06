package com.telran.contact;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {

    //static WebDriver driver;
    WebDriver driver;

    //@BeforeSuite
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://contacts-app.tobbymarshall815.vercel.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    //@AfterSuite(enabled=false)
    @AfterMethod (enabled=false)
    public void tearDown() {
        driver.quit();
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[contains(.,\"Sign Out\")]"));
    }

    public void isRegistrationFormPresent() {
        Assert.assertTrue(isElementPresent2(By.cssSelector(".login_login__3EHKB")));
    }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void fillRegistrationLoginForm(String email, String password) {
        type(By.cssSelector("[placeholder='Email']"), email);
        type(By.cssSelector("[placeholder='Password']"), password);
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


    public void jumpToFutter(By  locator) {
        driver.findElement(locator).sendKeys(Keys.CONTROL, Keys.END);
    }


    public void clickWithActions(By save) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(save);
        actions.moveToElement(element).build().perform();
        element.click();
    }

    public boolean isContactCreated(String text){
        List<WebElement> contact = driver.findElements(By.cssSelector("h2"));
        for (WebElement el: contact) {
            if(el.getText().contains(text)){
                return true;
            }
        }
        return false;
    }

    public int sizeOfContacts() {
        if (driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() >0 ) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;

    }

    public void removeContact() {
        if (!isContactListEmpty()) {
            driver.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
            driver.findElement(By.xpath("//*[text()='Remove']")).click();
        }
    }

    public boolean isContactListEmpty () {
        return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    public void logIn() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        fillRegistrationLoginForm("limmo12@gmail.com", "Zz1234567$");
        click(By.xpath("//button[contains(.,' Login')]"));
    }

    public void addContact() {
        int i = (int)((System.currentTimeMillis()/1000) % 3600);
        click(By.cssSelector("a:nth-child(5)"));
        type(By.cssSelector("input:nth-child(1)"), "Mark6");
        type(By.cssSelector("input:nth-child(2)"), "Knorr5");
        type(By.cssSelector("input:nth-child(3)"), "12345" + i);
        type(By.cssSelector("input:nth-child(4)"), "adam" + i + "@gm.com");
        type(By.cssSelector("input:nth-child(5)"), "Bern2");
        type(By.cssSelector("input:nth-child(6)"), "No add comments");
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void isHomeComponentPresent() {
        isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
    }

    public boolean isLoginTabPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,\"Sign Out\")]"));
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[contains(.,'Registration')]"));
    }

    public void clickOnLogInTab() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public boolean isRegistrationLoginFormPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public boolean isContactTabPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'CONTACTS')]"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[contains(.,' Login')]"));
    }
}
