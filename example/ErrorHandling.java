package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.lang.Thread.sleep;

public class ErrorHandling {

    public static void main(String[] args) throws Exception {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        boolean status = alert_handling(driver);
//        if(status) prompt_alert_handling(driver);
        //driver.get("E:\\OneDrive - K L University/Academics/SEMESTER-6/ST/STLABWORKSPACE/Lab-1/src/main/java/org/example/epam_testing_sample-1.html");
        //radio_button_handling(driver);
//        check_box_handling(driver);
        Drop_down_handling(driver);
        multiple_drop_down_handling(driver);
        Thread.sleep(2000);
        driver.quit();
    }

    public static String radio_button_handling(WebDriver driver){
        WebElement radio_element_1 = driver.findElement(By.name("group1"));
        System.out.println(radio_element_1.getAttribute("value"));
        WebElement radio_button_option = radio_element_1.findElement(By.xpath("//input[@value='Banana']"));
        radio_button_option.click();
        String selectedValue = radio_button_option.getAttribute("value");
        return selectedValue;
    }

    public static void check_box_handling(WebDriver driver) throws InterruptedException {
        WebElement checkBoxSelected = driver.findElement(By.name("confirm"));

        boolean isSelected = checkBoxSelected.isSelected();
        if(isSelected == false)
            checkBoxSelected.click();

        boolean isDisplayed = checkBoxSelected.isDisplayed();
        Thread.sleep(2000);
        if(isDisplayed == true)
            checkBoxSelected.click();

        boolean isEnabled = checkBoxSelected.isEnabled();
        Thread.sleep(2000);
        if(isEnabled == true)
            checkBoxSelected.click();
    }

    public static  void Drop_down_handling(WebDriver driver){
        driver.get("E:\\OneDrive - K L University/Academics/SEMESTER-6/ST/STLABWORKSPACE/Lab-1/src/main/java/org/example/epam_testing_sample-1.html");
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        // Create a Select object
        Select dropdown = new Select(dropdownElement);
        // Select an option by value
        dropdown.selectByValue("Option2");
        // Alternatively, you can select by visible text or index
        // dropdown.selectByVisibleText("Option2");
        // dropdown.selectByIndex(1);

        // Get the selected option's value
        String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");

        // Print the selected value
        System.out.println("Selected value: " + selectedValue);
    }

    public static  void multiple_drop_down_handling(WebDriver driver) throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);
//        dropdown.selectByValue("Option2");
//        // Alternatively, you can select by visible text or index
//        // dropdown.selectByVisibleText("Option2");
//        // dropdown.selectByIndex(1);
//        // Get the selected option's value
//        String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");
//        // Print the selected value
//        System.out.println("Selected value: " + selectedValue);
        List<WebElement> cm= dropdown.getOptions();
        for(WebElement i:cm)
        {
            System.out.println(i.getText());
        }
        dropdown.selectByIndex(1);
        Thread.sleep(3000);
        dropdown.selectByValue("Option2");
        Thread.sleep(2000);
        dropdown.selectByVisibleText("Option2");
        Thread.sleep(2000);
        String nm=dropdown.getFirstSelectedOption().getText();
        System.out.println(nm);
    }



    public  static  boolean alert_handling(WebDriver driver) throws InterruptedException {
        driver.get("https://testpages.eviltester.com/styled/alerts/alert-test.html");
        return true;
    }
    public static String simple_alert_handling(WebDriver driver) throws Exception{
        driver.findElement(By.cssSelector("#alertexamples")).click();
        String message = driver.switchTo().alert().getText();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        return message;
    }

    public static boolean  confirm_alert_handling_accept(WebDriver driver) throws Exception{
        driver.findElement(By.cssSelector("#confirmexample")).click();
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        return driver.findElement(By.id("confirmreturn")).getText().equals("true");
    }

    public static  boolean confirm_alert_handling_dismiss(WebDriver driver) throws Exception{
        driver.findElement(By.cssSelector("#confirmexample")).click();
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        return driver.findElement(By.id("confirmreturn")).getText().equals("true");
    }

    public static String prompt_alert_handling(WebDriver driver) throws Exception{
        driver.findElement(By.id("promptexample")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello my name is Akira");
        alert.accept();
        System.out.println(driver.findElement(By.id("promptretval")).getText());
        return driver.findElement(By.id("promptretval")).getText();
    }

}
