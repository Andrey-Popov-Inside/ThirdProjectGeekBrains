package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement button;

    public LoginPage(WebDriver driver){

        super(driver);
    }

    public void loginIn() {this.button.click();}

    public LoginPage setLogin(String login){
        this.userName.click();
        this.userName.sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String password){
        this.password.click();
        this.password.sendKeys(password);
        return this;
    }
}
