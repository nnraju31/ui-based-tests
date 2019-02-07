package com.starwars.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div[2]/div[1]/h2/strong[1]") private WebElement totalSearchResults;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div[2]/div[2]/section/ul/li") private List<WebElement> numberOfSearchResultsinFirstPage;

    public String getTotalSearchResults() {
        return totalSearchResults.getText();
    }

    public int getNumberOfSearchResultsinFirstPage() {
        return numberOfSearchResultsinFirstPage.size();
    }
}
