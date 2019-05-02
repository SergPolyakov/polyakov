package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.HomePage;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public  void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:/MyDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
