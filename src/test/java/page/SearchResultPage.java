package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * PageObject class for searchResultPage.
 */
public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement secondSearchResultPageButton;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to check if page was loaded.
     * @return true/false if page was loaded or not.
     */
    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/search");
    }

    /**
     * Method to count the number of search results on the searchResultPage.
     * @return count the number of search results on the searchResultPage.
     */
    public int getSearchResultsCount() {
        return searchResults.size();
    }

    /**
     * Method to check for searchTerm in search results on the searchResultPage.
     * @return searchResults list.
     */
    public List<String> getSearchResult(){
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchResult : searchResults) {

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchResult);

            String searchResultText = searchResult.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }

    /**
     * Method to go to the secondSearchResultPage.
     * @return new SecondSearchResultPage.
     */
    public SecondSearchResultPage goToSecondSearchResultPage() {
        secondSearchResultPageButton.click();
        return new SecondSearchResultPage(driver);

    }

}
