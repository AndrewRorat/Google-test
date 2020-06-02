package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage {
    private WebDriver driver;

    @FindBy(xpath = "//a/h3")
    private List<WebElement> searchResults;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText() {
        final int FIRST_RESULT = 0;
        return searchResults.get(FIRST_RESULT).getText();
    }
}