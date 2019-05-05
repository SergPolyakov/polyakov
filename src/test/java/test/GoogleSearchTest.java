package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchResultPage;
import page.SecondSearchResultPage;

import java.util.List;

/**
 * Basic google search test class.
 */
public class GoogleSearchTest extends BaseTest {

    /**
     * Basic test of the search function with  checking the number of search results and the presence of the search text in the results (on the first two pages of the search result).
     */
    @Test
    public void googleSearchTest(){
        String searchTerm = "selenium";

        SearchResultPage searchResultPage = homePage.search(searchTerm);

        Assert.assertTrue(searchResultPage.isPageLoaded(),
                "page.SearchResultPage is not loaded");

        Assert.assertEquals(searchResultPage.getSearchResultsCount(), 10,
                "Results count is wrong!");

        List<String> searchResults = searchResultPage.getSearchResult();

        for (String searchResult : searchResults) {
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "SearchTerm: " +searchTerm+ " not found in:  \n" +searchResult);
        }

        SecondSearchResultPage secondSearchResultPage = searchResultPage.goToSecondSearchResultPage();

        Assert.assertEquals(secondSearchResultPage.getSearchResultsCount2(), 10,
                "Results count is wrong!");

        List<String> searchResults2 = secondSearchResultPage.getSearchResult();

        for (String searchResult2 : searchResults2) {
            Assert.assertTrue(searchResult2.contains(searchTerm),
                    "SearchTerm: " +searchTerm+ " not found in:  \n" +searchResult2);
        }
    }

}
