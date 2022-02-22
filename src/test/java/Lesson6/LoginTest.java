package Lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginTest extends AbstractTest {

    @Test
    @DisplayName("Успешное логирование")
    void loginIn() {
        new SwagLabsPage(getWebDriver());
        new LoginPage(getWebDriver()).setLogin("standard_user").setPassword("secret_sauce").loginIn();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Swag Labs"), "Авторизация недоступна");
    }

    @Test
    @DisplayName("Неудачная авторизация")
    void failLogin(){
        new SwagLabsPage(getWebDriver());
        new LoginPage(getWebDriver()).setLogin("BadUserName").setPassword("BadSecretSauce").loginIn();
        Assertions.assertFalse(equals(getWebDriver().findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"))),"Авторизация успешна");
    }
}


