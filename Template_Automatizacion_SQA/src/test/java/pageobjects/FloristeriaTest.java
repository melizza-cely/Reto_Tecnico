package pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FloristeriaTest {

    public WebDriver driver;

    @Step("Paso 1: Configuracion del navegador y abrir la pagina web")
    public void setupAndOpenWebsite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.floristeriamundoflor.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
    }

    @Step("Paso 2: Hacer clic en la categoria 'Amor'")
    public void clickLoveCategory() {
        driver.findElement(By.xpath("//li[@id='menu-item-2806']/a[text()='Amor']")).click();
    }

    @Step("Paso 3: Seleccionar el primer producto")
    public void selectFirstProduct() {
        driver.findElement(By.xpath("//figure[@class='image']/a")).click();
    }

    @Step("Paso 4: Agregar el primer producto al carrito")
    public void addToCartFirstProduct() {
        driver.findElement(By.xpath("//button[@name='add-to-cart']")).click();
    }

    @Step("Paso 5: Seguir comprando")
    public void continueShopping() {
        driver.findElement(By.xpath("//a[@class='button wc-forward']")).click();
    }

    @Step("Paso 6: Hacer scroll")
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 700);");
    }

    @Step("Paso 7: Seleccionar el segundo producto")
    public void selectSecondProduct() {
        driver.findElement(By.xpath("//figure[@class='image']/a")).click();
    }

    @Step("Paso 8: Agregar el segundo producto al carrito")
    public void addToCartSecondProduct() {
        driver.findElement(By.xpath("//button[@name='add-to-cart']")).click();
    }

    @Step("Paso Final: Cerrar el navegador")
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void Scenario1() {
        FloristeriaTest test = new FloristeriaTest();
        test.setupAndOpenWebsite();
        test.clickLoveCategory();
        test.selectFirstProduct();
        test.addToCartFirstProduct();
        test.continueShopping();
        test.scrollDown();
        test.selectSecondProduct();
        test.addToCartSecondProduct();
        test.closeBrowser();
    }

    @Step("Paso 2: Seleccionar la categoria 'Cumpleanios'")
    private void selectBirthdayCategory() {
        driver.findElement(By.xpath("//li[@id='menu-item-2799']/a[contains(text(),'Cumplea')]")).click();
    }

    @Step("Paso 9: Eliminar el primer producto del carrito")
    private void removeFirstProductFromCart() {
        driver.findElement(By.xpath("//td[@class='product-remove']/a")).click();
    }

    @Test
    public void Scenario2() {
        FloristeriaTest test = new FloristeriaTest();
        test.setupAndOpenWebsite();
        test.selectBirthdayCategory();
        test.selectFirstProduct();
        test.addToCartFirstProduct();
        test.continueShopping();
        test.scrollDown();
        test.selectSecondProduct();
        test.addToCartSecondProduct();
        test.removeFirstProductFromCart();
        test.closeBrowser();
    }
}