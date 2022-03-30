package base;

import framework.Configuration;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AdminPage;
import pages.LoginPage;

public class BaseTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUpClass() throws IOException {
        Configuration.init();
        System.setProperty("webdriver.chrome.driver", Configuration.chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Configuration.startPage);
    }

    @AfterClass
    public static void tearDownClass() throws InterruptedException {
//        Thread.sleep(1500);
//        driver.quit();
    }

    @Test
    public void testOpenHomePage() {
        assertEquals("URL doesn't match", driver.getCurrentUrl(), Configuration.startPage);
    }

    @Test
    public void testChangeCurrency() throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        String newCurrency = "GBP";
        adminPage.setCurrency(newCurrency);
        assertEquals("Error - Currency not set", adminPage.getCurrentCurrency(), newCurrency);
    }

    @Test
    public void testChangeEachAvailableCurrency() throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        String newCurrency;
        List<String> allCurrencies = adminPage.getAllAvailableCurrenciesBox();
        for (int x = 0; x < allCurrencies.size(); x++) {
            newCurrency = allCurrencies.get(x);
            adminPage.setCurrency(newCurrency);
            assertEquals("Error - Currency not set", adminPage.getCurrentCurrency(), newCurrency);
        }
    }

    @Test
    public void login() throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();        //        
    }

    
    
    
    
    
    
    
    
    
    
}
