package Lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class LoginTest extends AbstractTest{

    @Test
    @DisplayName("Авторизация на сайте")
    void myLoginTest() {
        Actions loginIn = new Actions(getDriver());
        loginIn.sendKeys(getDriver().findElement(By.id("user-name")), "standard_user")
                .click(getDriver().findElement(By.id("password")))
                .sendKeys("secret_sauce")
                .click(getDriver().findElement(By.id("login-button")))
                .build()
                .perform();

        Assertions.assertTrue(getDriver().getTitle().equals("Swag Labs"), "Авторизация недоступна");



    }
    @Test
    @DisplayName("Неудачная авторизация на сайте")
    void failLoginTest(){
        Actions failLogin = new Actions(getDriver());
        failLogin.sendKeys(getDriver().findElement(By.id("user-name")),"BadUser")
                .click(getDriver().findElement(By.id("password")))
                .sendKeys("12345")
                .click(getDriver().findElement(By.id("login-button")))
                .build()
                .perform();

        Assertions.assertFalse(equals(getDriver().findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"))),"Авторизация успешна");
    }
}
