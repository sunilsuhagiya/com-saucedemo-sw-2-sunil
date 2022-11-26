package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }


    public String getTextFromElement(By by){
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // Click on login button using By.id method
        clickOnElement(By.id("login-button"));
        // Send user name using By.id method
        sendTextToElement(By.id("user-name"),"standard_user");
        // Send password using By.name method
        sendTextToElement(By.name("password"),"secret_sauce");
        // click on login button using xpath
        clickOnElement(By.xpath("//input[@id='login-button']"));
        // Actual Requirements
        String expectedMessage = "PRODUCTS";
        // Storing value in string to compare actual message
        String actualMessage = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));

        //clickOnElement(By.xpath("//button[contains(text(),'Log out')]"));
        //clickOnElement(By.linkText("Log out"));
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        // Click on login button using By.id method
        clickOnElement(By.id("login-button"));
        // Send user name using By.id method
        sendTextToElement(By.id("user-name"),"standard_user");
        // Send password using By.name method
        sendTextToElement(By.name("password"),"secret_sauce");
        // click on login button using xpath
        clickOnElement(By.xpath("//input[@id='login-button']"));

        int expectedNumber=6;
        List<WebElement> list = driver.findElements(By.className("inventory_item"));
        int actualNumber = list.size();
        System.out.println("Number of products per page: "  + actualNumber);
        Assert.assertEquals(expectedNumber,actualNumber);
    }

    @After
    public void testDown(){
        //closeBrowser();
    }

}