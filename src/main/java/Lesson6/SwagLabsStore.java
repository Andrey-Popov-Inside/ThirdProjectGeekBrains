package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwagLabsStore extends AbstractPage{

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addLabsBike;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement cartContainer;

    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-backpack\"]")  //remove-sauce-labs-backpack
    private WebElement removeLabsBike;

    @FindBy(xpath = "//*[@id=\"item_4_img_link\"]/img")
    private WebElement imgLabsBike;

    @FindBy(id = "continue-shopping")
    private WebElement continueShopping;

    @FindBy(id = "checkout")
    private WebElement checkout;

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueTitle;

    @FindBy(id = "finish")
    private WebElement finish;

    @FindBy(id = "back-to-products")
    private WebElement backTpProducts;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    private WebElement cartContainerOne;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[1]/img")
    private WebElement Image;

    @FindBy(xpath = ".//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a")
    private WebElement page_wrapper;

    public SwagLabsStore(WebDriver driver){

        super(driver);
    }

    public void addProduct(){
        this.addLabsBike.click();
        this.cartContainer.click();
        new WebDriverWait(getDriver(),4).until(ExpectedConditions.visibilityOf(cartContainerOne));
    }

    public void removeProduct(){
        this.addLabsBike.click();
        this.cartContainer.click();
        this.removeLabsBike.click();
        this.continueShopping.click();
    }

    public void changeProduct(){
        this.addLabsBike.click();
        this.cartContainer.click();
        new WebDriverWait(getDriver(),4).until(ExpectedConditions.visibilityOf(checkout));
        this.checkout.click();
    }

    public SwagLabsStore setFirstName(String firstName){
        this.firstName.click();
        this.firstName.sendKeys(firstName);
        return this;
    }
    public SwagLabsStore setLastName(String lastName){
        this.lastName.click();
        this.lastName.sendKeys(lastName);
        return this;
    }
    public SwagLabsStore setPostalCode(String postalCode){
        this.postalCode.click();
        this.postalCode.sendKeys(postalCode);
        return this;
    }
    public void continueClick(){
        this.continueTitle.click();
        this.finish.click();
        this.backTpProducts.click();
    }
    public void getFacebookTitle(){
        this.cartContainer.click();
        this.page_wrapper.click();
    }
}
