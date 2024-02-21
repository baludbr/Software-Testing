package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

import static org.openqa.selenium.By.*;

public class Link_text_and_PartialLinktext {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(Credentials.LMS_URL);
        String title = driver.getTitle();
        driver.findElement(linkText("Lost password?")).click();
        //driver.findElement(partialLinkText("Lost")).click();
        driver.quit();
    }
}
