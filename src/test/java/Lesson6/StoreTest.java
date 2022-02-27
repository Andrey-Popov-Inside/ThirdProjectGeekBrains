package Lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class StoreTest extends AbstractStoreTest{

    @Test
    @DisplayName("Добавление товара в корзину")
    void addProduct(){
        new SwagLabsStore(getWebDriver()).addProduct();
        getWebDriver().getCurrentUrl();
        Assertions.assertFalse(equals(getWebDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"))),"Товар не добавлен");
    }

    @Test
    @DisplayName("Удаление товара из корзины")
    void removeProduct(){
        new SwagLabsStore(getWebDriver()).removeProduct();
        getWebDriver().getCurrentUrl();
        Assertions.assertFalse(equals(getWebDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"))),"Товар не удален");
    }

    @Test
    @DisplayName("Офрмление и покупка товара")
    void changeProduct(){
        new SwagLabsStore(getWebDriver()).changeProduct();
        new SwagLabsStore(getWebDriver()).setFirstName("Andrey").setLastName("Popov").setPostalCode("197044").continueClick();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Swag Labs"), "Заказ не оформлен");
    }

    @Test
    @DisplayName("Переход на Facebook по ссылке")
    void getFacebook(){
        new SwagLabsStore(getWebDriver()).getFacebookTitle();
        getWebDriver().getCurrentUrl();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Swag Labs"), "открытие страницы Facebook недоступно");
    }
}
