package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookie_Handling {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://lms.kluniversity.in/login/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys(Credentials.LMS_USERNAME);
        driver.findElement(By.id("password")).sendKeys(Credentials.LMS_PASSWORD);
        highlight(driver,driver.findElement(By.partialLinkText("Lost")));
        driver.findElement(By.id("password")).submit();
        Thread.sleep(3000);
        for(Cookie cook:driver.manage().getCookies()){
            System.out.println(cook.getName()+" "+cook.getValue());

        }
        driver.manage().deleteCookieNamed("MoodleSession");
        driver.findElement(By.xpath("//button[@data-action='new-event-button']")).click();
    }

    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    }
