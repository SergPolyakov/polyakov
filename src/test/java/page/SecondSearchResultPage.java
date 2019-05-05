package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * PageObject class for secondSearchResultPage.
 */
public class SecondSearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> searchResults2;

    public SecondSearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to count the number of search results on the secondSearchResultPage.
     * @return count the number of search results on the secondSearchResultPage.
     */
    public int getSearchResultsCount2() {
        return searchResults2.size();
    }

    /**
     * Method to check for searchTerm in search results on the secondSearchResultPage.
     * @return searchResults list.
     */
    public List<String> getSearchResult(){
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchResult : searchResults2) {

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchResult);

            String searchResultText = searchResult.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }
}
