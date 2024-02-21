import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class codechef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://leetcode.com/accounts/login/");
        driver.findElement(By.id("id_login")).sendKeys("dwarampudibalajireddy@gmail.com");
        driver.findElement(By.id("id_password")).sendKeys("Baludbr@14");
        driver.findElement(By.className("sign-in-box__1t5d")).submit();
	}

}
