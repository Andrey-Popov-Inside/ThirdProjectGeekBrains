package Lesson6;

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

    static WebDriver WebDriver;


    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();      // установка драйвера.
        ChromeOptions options=new ChromeOptions();   //Опции Хрома.
        options.addArguments("start-maximized");     //Открытие полноэкранного формата.
        options.addArguments("--incognito");        //Открытие страницы в режиме инкогнито.
        options.addArguments("disable-popup-blocking");      //Блокировка всплывающих окон.
        WebDriver = new ChromeDriver(options);    //Создали вэб-драйвер и запустили браузер.
        WebDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);     //Неявное ожидание.
    }

    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow( ()-> WebDriver.navigate().to("https://www.saucedemo.com/"),
                "Страница не доступна");
    }



    @AfterAll
    static void close(){
        WebDriver.quit();
    }

    public static WebDriver getWebDriver() {
        return WebDriver;
    }

}