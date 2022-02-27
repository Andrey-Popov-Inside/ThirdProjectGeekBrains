package Lesson7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class AbstractStoreTest {

    static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();      //Скачивание и установка драйвера.
        ChromeOptions options=new ChromeOptions();   //Опции Хрома.
        options.addArguments("start-maximized");     //Открытие полноэкранного формата.
        options.addArguments("--incognito");        //Открытие страницы в режиме инкогнито.
        options.addArguments("disable-popup-blocking");      //Блокировка всплывающих окон.
        driver = new ChromeDriver(options);    //Создали вэб-драйвер и запустили браузер.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);     //Неявное ожидание.
    }

    @BeforeEach
    void goTo() {
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://www.saucedemo.com/"),
                "Страница не доступна");
        getDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        WebElement webElement = driver.findElement(By.id("login-button"));
        webElement.click();



    }



    @AfterAll
    static void close(){
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}