import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleTitle() {
        String baseUrl = "https://www.google.com";
        String expectedTitle = "Google";

        driver.get(baseUrl);
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testLmsTitle() {
        String baseUrl = "https://lms.kluniversity.in/login/";
        String expectedTitle = "LMS";

        driver.get(baseUrl);
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}