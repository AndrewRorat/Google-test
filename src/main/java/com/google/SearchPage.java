package com.google;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchField;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage insertTextToSearch(String text) {
        searchField.click();
        searchField.sendKeys(text);
        return this;
    }

    public ResultPage clickEnterToSearch() {
        searchField.sendKeys(Keys.RETURN);
        return PageFactory.initElements(driver, ResultPage.class);
    }
}