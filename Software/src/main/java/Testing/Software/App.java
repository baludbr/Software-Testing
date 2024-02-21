package Testing.Software;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class App{
    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: pink; border: 2px solid black;');", element);
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner s=new Scanner(System.in);
        while(true){
            System.out.println("Select One option");
            System.out.println("1.opening the browser\n" +
                    "2.opening the given url\n" +
                    "3.open the browser if the credentials are correct\n" +
                    "4.open the url and give responses of the invalid credentials\n" +
                    "5.Implement all locators (static)\n" +
                    "6.Implement CSSSelector(dynamic)\n" +
                    "7.Implement Xpath(dynamic)\n" +
                    "8.Develop all Html Controls including checkbox radio button drop downs(single and multiple) separately\n" +
                    "9.Implement all Alerts(simple alert,confirm,prompt alert)separate programs\n" +
                    "10.Implement window/screenshot after pushing the code into your github account\n"+
                    "11.Close\n");
            System.out.println("Select an Option");
            int t=s.nextInt();
            WebDriver driver;
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            if(t==1){
                driver.get("https://leetcode.com/accounts/login/");
                String title = driver.getTitle();
                System.out.println(title);
                driver.quit();
            }
            else if(t==2){
                System.out.println("Enter the  URL you want to open!!");
                String ss=s.next();
                driver.get(ss);
                String title = driver.getTitle();
                System.out.println(title);
                driver.quit();
            }
            else if(t==3){

                driver.get("https://leetcode.com/accounts/login/");
                driver.findElement(By.id("id_login")).sendKeys("dwarampudibalajireddy@gmail.com");
                driver.findElement(By.id("id_password")).sendKeys("Baludbr@14");
                driver.findElement(By.className("sign-in-box__1t5d")).submit();
            }
            else if(t==4){
                driver.get("https://leetcode.com/accounts/login/");
                driver.findElement(By.id("id_login")).sendKeys("dwarampudibalajireddy@gmail.com");
                driver.findElement(By.id("id_password")).sendKeys("Baludbr@141");
                driver.findElement(By.className("sign-in-box__1t5d")).submit();
            }
            else if(t==5){
                driver.get("https://lms.kluniversity.in/login/index.php");
                System.out.println(driver.getTitle());

                // Example of highlighting for different locators
                WebElement loginField = driver.findElement(By.id("username"));
                WebElement passwordField = driver.findElement(By.name("password"));
                WebElement logo = driver.findElement(By.className("span12"));
                WebElement forgotPasswordLink = driver.findElement(By.linkText("Lost password?"));
                WebElement h1Tag = driver.findElement(By.tagName("h1"));
                WebElement partialLink = driver.findElement(By.partialLinkText("ost pass"));
                // Highlighting each element
                highlight(driver, loginField);
                driver.findElement(By.name("password")).sendKeys("welcome");
                highlight(driver, passwordField);
                driver.findElement(By.className("span12"));
                highlight(driver, logo);
                highlight(driver, forgotPasswordLink);
                driver.findElement(By.tagName("h1"));
                highlight(driver, h1Tag);
                highlight(driver,partialLink);
            }
            else if(t==6){
                driver.get("https://lms.kluniversity.in/login/index.php");
                System.out.println(driver.getTitle());
                WebElement xpathapp=driver.findElement(By.xpath("//div[@id='wrapper']"));
                highlight(driver,xpathapp);
            }
            else if(t==7){

                driver.get("https://lms.kluniversity.in/login/index.php");
                System.out.println(driver.getTitle());
                WebElement csspathapp=driver.findElement(By.cssSelector("#logoimage"));
                highlight(driver,csspathapp);
            }
            else if(t==8){
                System.out.println("1.Check-Box");
                System.out.println("2.Radio-Button");
                System.out.println("3.Drop-Down");
                driver.get("F:\\Software-testing\\Software\\src\\main\\java\\Testing\\Software\\Main.html");
                int kk=s.nextInt();
                if(kk==1){
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
                else if(kk==2){
                    WebElement radio_element_1 = driver.findElement(By.name("group1"));
                    System.out.println(radio_element_1.getAttribute("value"));
                    WebElement radio_button_option = radio_element_1.findElement(By.xpath("//input[@value='Banana']"));
                    radio_button_option.click();
                    String selectedValue = radio_button_option.getAttribute("value");
                }
                else{
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

            }
            else if(t==9){
                System.out.println("1.Simple Alert");
                System.out.println("2.Confirm Alert");
                System.out.println("3.Prompt Alert");
                System.out.println("Select an Option");
                int rr=s.nextInt();
                if(rr==1){
                    driver.manage().window().maximize();
                    driver.get("F:\\Software-testing\\Software\\src\\main\\java\\Testing\\Software\\index.html");

                    System.out.println(driver.findElement(By.id("output")).getText());
                    Thread.sleep(2000);
                    driver.findElement(By.id("alertBox")).click();
                    Thread.sleep(2000);
                    System.out.println(driver.switchTo().alert().getText());
                    Thread.sleep(2000);
                    driver.switchTo().alert().accept();
                    Thread.sleep(2000);
                    System.out.println(driver.findElement(By.id("output")).getText());

                }
                else if(rr==2){

                    driver.manage().window().maximize();
                    driver.get("F:\\Software-testing\\Software\\src\\main\\java\\Testing\\Software\\index.html");
                    System.out.println(driver.findElement(By.id("output")).getText());
                    Thread.sleep(2000);
                    driver.findElement(By.id("confirmBox")).click();
                    Thread.sleep(2000);
                    System.out.println(driver.switchTo().alert().getText());
                    Thread.sleep(2000);
                    driver.switchTo().alert().accept();
                    Thread.sleep(2000);
                    System.out.println(driver.findElement(By.id("output")).getText());
                    System.out.println(driver.findElement(By.id("output")).getText());
                    Thread.sleep(2000);
                    driver.findElement(By.id("confirmBox")).click();
                    Thread.sleep(2000);
                    System.out.println(driver.switchTo().alert().getText());
                    Thread.sleep(2000);
                    driver.switchTo().alert().dismiss();
                    Thread.sleep(2000);
                    System.out.println(driver.findElement(By.id("output")).getText());
                }
                else{
                    driver.manage().window().maximize();
                    driver.get("F:\\Software-testing\\Software\\src\\main\\java\\Testing\\Software\\index.html");
                    System.out.println(driver.findElement(By.id("output")).getText());
                    Thread.sleep(2000);
                    driver.findElement(By.id("promptBox")).click();
                    Thread.sleep(2000);
                    System.out.println(driver.switchTo().alert().getText());
                    Thread.sleep(2000);
                    driver.switchTo().alert().sendKeys("dbr");
                    driver.switchTo().alert().accept();
                    Thread.sleep(2000);
                    System.out.println(driver.findElement(By.id("output")).getText());
                    driver.findElement(By.id("promptBox")).click();
                    Thread.sleep(2000);
                    driver.switchTo().alert().dismiss();
                    Thread.sleep(2000);
                    System.out.println(driver.findElement(By.id("output")).getText());
                    Thread.sleep(2000);

                }

            }else if(t==10){
                driver.get("https://github.com/login");
                TakesScreenshot ts=(TakesScreenshot)driver;
                File file=ts.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(file, new File("./screenshots/img1.png"));

            }else if(t==11){
                break;
            }
        }
    }
}
