package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@id='vn1s0p1c0']//h3[@class='sA5rQ']")
    private WebElement firstTitleText;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText(){
        return firstTitleText.getText();
    }

    @Override
    public String toString() {
        return "ResultPage{" +
                "firstTitleText=" + firstTitleText +
                '}';
    }
}
