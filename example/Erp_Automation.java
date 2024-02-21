package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Erp_Automation {
    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Credentials.KLU_ERP_URL);
        driver.findElement(By.linkText("Login")).click();
        //driver.findElement(By.id("loginform-username")).sendKeys(Credentials.KLU_ERP_USERNAME);
        //driver.findElement(By.xpath("/html[1]/body[1]/div[3]")).sendKeys(Credentials.KLU_ERP_PASSWORD);
        WebElement imageElement = driver.findElement(By.id("loginform-captcha-image"));
        String imageURL = imageElement.getAttribute("src");
        downloadImage(imageURL, "./Screenshots/Captcha.png");
        driver.quit();
    }

    public static void downloadImage(String imageURL, String destinationPath) {
        try {
            URL url = new URL(imageURL);
            URLConnection connection = url.openConnection();

            try (BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(destinationPath)) {

                byte[] dataBuffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            }

            System.out.println("Image downloaded successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
}
