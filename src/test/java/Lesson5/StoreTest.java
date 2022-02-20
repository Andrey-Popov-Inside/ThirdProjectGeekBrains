package Lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class StoreTest extends AbstractStoreTest{

    @Test
    @DisplayName("Добавление товара в корзину")
    void addProduct() {
        Actions add = new Actions(getDriver());
        add.click(getDriver().findElement(By.id("add-to-cart-sauce-labs-bike-light")))
                .click(getDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")))
                .build()
                .perform();

        Assertions.assertFalse(equals(getDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"))),"Товар не добавлен");

    }

    @Test
    @DisplayName("Удаление товара из корзины")
    void removeProduct() {
        Actions removePr = new Actions(getDriver());
        removePr.click(getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")))
                .click(getDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")))
                .click(getDriver().findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a")))
                .click(getDriver().findElement(By.id("checkout")))
                .build()
                .perform();

        Assertions.assertFalse(equals(getDriver().findElement(By.xpath(".//*[@class=\"shopping_cart_container\"]/a"))),"Товар не удален");
    }
}
