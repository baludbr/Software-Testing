import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
	public static void main(String[] args) {
		 WebDriver wb;
		 WebDriverManager.chromedriver().setup();
		 wb=new ChromeDriver();
		 wb.get("https://www.amazon.in");
		 //wb.quit();
	}
}
