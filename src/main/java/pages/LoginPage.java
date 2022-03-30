package pages;

import framework.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AdminPage {

    private WebDriver driver;
    private final By emailField = By.name("name");
    private final By passwordField = By.name("password");
    private final By loginButton = By.className("ladda-label");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() throws InterruptedException {
        driver.findElement(emailField).sendKeys(Configuration.validEmail);
        driver.findElement(passwordField).sendKeys(Configuration.validPassword);
        driver.findElement(loginButton).click();
    }

}
