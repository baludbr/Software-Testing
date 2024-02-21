import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {
	public static void main(String[] args) throws IOException {
		WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://github.com/login");
        TakesScreenshot ts=(TakesScreenshot)driver;
        File file=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./screenshots/img1.png"));
	}

}
