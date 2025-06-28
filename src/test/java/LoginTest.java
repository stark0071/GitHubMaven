import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTest {

    public static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void doLogin() {
        driver.get("https://www.saucedemo.com/");

        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        WebElement password = driver.findElement(By.id("password"));

        //user-name
        username.sendKeys("standard_user");
        //password
        password.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
