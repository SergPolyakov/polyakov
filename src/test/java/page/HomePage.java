package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject class for homePage.
 */
public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    /**
     * Constructor of HomePage object.
     * @param driver Webdriver instance from baseTest.
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to enter search term in the search field and press enter button.
     * @param searchTerm - text to be entered in the search field.
     * @return New SearchResult page.
     */
    public SearchResultPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);


    }
}
