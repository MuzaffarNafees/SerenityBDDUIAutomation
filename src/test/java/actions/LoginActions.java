package actions;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class LoginActions extends PageObject {


    public void openLoginPage() {
        openUrl("https://opensource-demo.orangehrmlive.com/");
    }
    private static final By USERNAME_FIELD = By.name("username");
    private static final By PASSWORD_FIELD = By.name("password");
    private static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");

    public void enterUsername(String username) {
        WebElement usernameField = getDriver().findElement(USERNAME_FIELD);
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = getDriver().findElement(PASSWORD_FIELD);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = getDriver().findElement(LOGIN_BUTTON);
        loginButton.click();
    }
    
}
