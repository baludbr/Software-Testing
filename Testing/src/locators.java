import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://github.com/login");
        driver.findElement(By.id("login_field")).sendKeys("baludbr");
        driver.findElement(By.id("password")).sendKeys("Balubalaji@14");
        driver.findElement(By.name("commit")).submit();
	}

}
