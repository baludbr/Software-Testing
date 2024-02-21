package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.By.*;


public class Locators_in_HTML {
    public static void main(String[] args) {
        //Demo Static Locators
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(Credentials.LMS_URL);
        String title = driver.getTitle();
        //by Id
        //driver.findElement(id("username")).sendKeys(Credentials.LMS_USERNAME);
        //by name
        driver.findElement(name("username")).sendKeys(Credentials.LMS_USERNAME);
        driver.findElement(id("password")).sendKeys(Credentials.LMS_PASSWORD);
        //driver.findElement(id("loginbtn")).submit();
        //by class name
        driver.findElement(className("btn-lg")).submit();
        System.out.println(title);
        driver.quit();
    }
}
