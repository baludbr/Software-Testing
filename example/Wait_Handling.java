package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Wait_Handling {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        implict_wait_function(driver);
        explicit_wait_function(driver);
        user_wait_function(driver);


    }

    public static void implict_wait_function(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Credentials.LMS_URL);
        System.out.println(driver.getTitle());
    }

    public static void explicit_wait_function(WebDriver driver){
        driver.get(Credentials.LMS_URL);
        WebElement myDynamicElement = (new WebDriverWait(driver,Duration.ofSeconds(10))).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver input) {
                return input.findElement(By.name("username"));
            }
        });
    }

    public static void user_wait_function(WebDriver driver) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement nextPage = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.name("username"));
            }
        });
    }

}
