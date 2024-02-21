import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class StaticLocators {
	public static void main(String a[])
	{
		 WebDriver driver;
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://lms.kluniversity.in/login/");
	        driver.findElement(By.id("email")).sendKeys("2100030140");
	        driver.findElement(By.id("password")).sendKeys("Baludbr@14");
	        driver.findElement(By.id("loginbtn")).submit();
	        driver.quit();
	}
}
