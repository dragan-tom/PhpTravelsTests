package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {

    private final WebDriver driver;
    private final By currency = By.id("currency");    
    private final By allCurrencies = By.xpath("//*[@id=\"fadein\"]/header/div[1]/div/div/div[2]/div/div/div[2]/div/ul");
    private final By loginButton = By.partialLinkText("Login");
    
    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getCurrentCurrency(){
        String currentCurrency = driver.findElement(currency).getText();
        return currentCurrency;
    }
    
    public List<String> getAllAvailableCurrenciesBox() throws InterruptedException{
        driver.findElement(currency).click();
        WebElement allCurrenciesBox = driver.findElement(allCurrencies);
        List<String> newList = new ArrayList<>();
        List<WebElement> allElements = allCurrenciesBox.findElements(By.tagName("li"));                                
        allElements.forEach(allElement -> {
            newList.add(allElement.getText());
        });
        driver.findElement(currency).click();
        return newList;
    }
    
    public void setCurrency(String newCurrency) throws InterruptedException{
        driver.findElement(currency).click();
        driver.findElement(By.partialLinkText(newCurrency)).click();
    }
    
    public void goToLoginPage(){
        driver.findElement(loginButton).click();
    }
    
}
