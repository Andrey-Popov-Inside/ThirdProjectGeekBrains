package Lesson7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    private static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();      // установка драйвера.
        ChromeOptions options=new ChromeOptions();   //Опции Хрома.
        options.addArguments("start-maximized");     //Открытие полноэкранного формата.
        options.addArguments("--incognito");        //Открытие страницы в режиме инкогнито.
        options.addArguments("disable-popup-blocking");      //Блокировка всплывающих окон.
        driver = new ChromeDriver(options);    //Создали вэб-драйвер и запустили браузер.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);     //Неявное ожидание.
    }

    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://www.saucedemo.com/"),
                "Страница не доступна");
    }



    @AfterAll
    static void close(){
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}