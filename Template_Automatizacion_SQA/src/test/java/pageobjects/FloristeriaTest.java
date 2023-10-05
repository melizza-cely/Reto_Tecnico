package pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class FloristeriaTest {

    protected WebDriver driver;

   @Test
    public void Scenario1(){

       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();

       driver.get("https://www.floristeriamundoflor.com/");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
       driver.quit();
    }

    @Test
    public void Scenario2(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.floristeriamundoflor.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.quit();
    }
}