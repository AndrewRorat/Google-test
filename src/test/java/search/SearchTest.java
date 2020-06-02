package search;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testRunner.LocalTestRunner;

public class SearchTest extends LocalTestRunner {

    @Parameters({"searchingText"})
    @Test(description = "Check search field")
    public void searchTest(String text) {
        String titleText = searchPage
                .insertTextToSearch(text)
                .clickEnterToSearch()
                .getTitleText();

        System.out.println("First title of response is:\n - " + titleText);
    }
}