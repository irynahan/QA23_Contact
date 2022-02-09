package com.telran.contact.framework;

import com.telran.contact.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
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
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;

    }

    public void removeContact() {
        if (!isContactListEmpty()) {
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//*[text()='Remove']"));
        }
    }

    public boolean isContactListEmpty () {
        return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    public void addContact(Contact contact) {
        int i = (int)((System.currentTimeMillis()/1000) % 3600);
        click(By.cssSelector("a:nth-child(5)"));
        type(By.cssSelector("input:nth-child(1)"), contact.getName());
        type(By.cssSelector("input:nth-child(2)"), contact.getLastName());
        type(By.cssSelector("input:nth-child(3)"), contact.getPhone());
        type(By.cssSelector("input:nth-child(4)"), contact.getEmail());
        type(By.cssSelector("input:nth-child(5)"), contact.getAddress());
        type(By.cssSelector("input:nth-child(6)"), contact.getDescription());
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

}
