package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;
public class MenuDriven {
    public static void main(String[] args) {
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
            if(t==1){
                WebDriver driver;
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get("https://lms.kluniversity.in/login/index.php");
                String title = driver.getTitle();
                System.out.println(title);
                driver.quit();
            }
            else if(t==2){

            }
            else if(t==3){

            }
            else if(t==4){

            }
            else if(t==5){

            }
            else if(t==6){

            }
            else if(t==7){

            }else if(t==8){

            }
            else if(t==9){

            }else if(t==10){

            }else if(t==11){

            }
            else if(t==12){
                break;
            }




        }
    }
}
