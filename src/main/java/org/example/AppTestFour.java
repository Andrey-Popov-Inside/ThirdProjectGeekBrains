package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class AppTestFour
{
    public static void main( String[] args ){

        WebDriverManager.chromedriver().setup();      //Скачивание и установка драйвера.
        ChromeOptions options=new ChromeOptions();   //Опции Хрома.
        options.addArguments("start-maximized");     //Открытие полноэкранного формата.
        options.addArguments("--incognito");        //Открытие страницы в режиме инкогнито.
        options.addArguments("disable-popup-blocking");      //Блокировка всплывающих окон.
        WebDriver driver = new ChromeDriver(options);    //Создали вэб-драйвер и запустили браузер.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);     //Неявное ожидание.
        driver.get("https://www.saucedemo.com/");     //Открытие нужной нам страницы.


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.xpath(".//*[@class=\"shopping_cart_container\"]/a")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Andrey");
        driver.findElement(By.id("last-name")).sendKeys("Popov");
        driver.findElement(By.id("postal-code")).sendKeys("197044");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        driver.findElement(By.id("back-to-products")).click();
        driver.quit();

    }
}
