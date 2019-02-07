package com.starwars.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VideoPage {

    WebDriver driver;

    public VideoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//*[@id=\"section-links\"]/li[4]/a/span[2]") private WebElement films;
    @FindBy(xpath = "//*[@id=\"section-links\"]/li[2]/a/span[2]") private WebElement video;
    @FindBy(xpath = "//*[@id=\"social-links\"]/li[1]/a") private WebElement faceBookIcon;
    @FindBy(xpath = "//*[@id=\"nav-utility\"]/div[2]/div[1]/div[1]") private WebElement login;
    @FindBy(xpath = "//*[@id=\"nav-utility\"]/div[2]/div[1]/div[2]") private WebElement signUP;
    @FindBy(id = "nav-search-input") private WebElement searchTextBox;
    @FindBy(xpath = "//*[@id=\"nav-sw-logo\"]") private WebElement starWarLogo;

    @FindBy(xpath = "(//span[@class='long-title'])[1]") private WebElement filmName1;
    @FindBy(xpath = "(//span[@class='long-title'])[2]") private WebElement filmName2;

    @FindBy(xpath = "//*[@id=\"ref-1-0\"]/div/form/div[2]/input[1]") private WebElement searchBox;
    @FindBy(xpath = "//*[@id=\"ref-1-0\"]/div/form/div[2]/span/input") private WebElement searchIcon;

    @FindBy(xpath = "//*[@id=\"ref-1-1\"]/div[1]/div[1]/h2") private WebElement selectionHeader1;
    @FindBy(xpath = "//*[@id=\"ref-1-2\"]/div[1]/div[1]/h2") private WebElement selectionHeader2;
    @FindBy(xpath = "//*[@id=\"ref-1-3\"]/div[1]/div[1]/h2") private WebElement selectionHeader3;
    @FindBy(xpath = "//*[@id=\"ref-1-4\"]/div[1]/div[1]/h2") private WebElement selectionHeader4;
    @FindBy(xpath = "//*[@id=\"ref-1-5\"]/div[1]/div[1]/h2") private WebElement selectionHeader5;

    @FindBy(xpath = "//*[@id=\"ref-1-5\"]/div[1]/div[2]/ul/li") private List<WebElement> browserOptions;
    @FindBy(xpath = "//*[@id=\"nav-ac\"]/li[6]/a") private WebElement browseViewAllDynamicElement;

    public WebElement getSelectionHeader4() {
        return selectionHeader4;
    }

    public WebElement getSelectionHeader5() {
        return selectionHeader5;
    }

    public WebElement getFilms() {
        return films;
    }

    public WebElement getVideo() {
        return video;
    }

    public WebElement getFaceBookIcon() {
        return faceBookIcon;
    }

    public WebElement getLogin() {
        return login;
    }

    public WebElement getSignUP() {
        return signUP;
    }

    public WebElement getSearchTextBox() {
        return searchTextBox;
    }

    public WebElement getStarWarLogo() {
        return starWarLogo;
    }

    public WebElement getFilmName1() {
        return filmName1;
    }

    public WebElement getFilmName2() {
        return filmName2;
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSearchIcon() {
        return searchIcon;
    }

    public WebElement getSelectionHeader1() {
        return selectionHeader1;
    }

    public WebElement getSelectionHeader2() {
        return selectionHeader2;
    }

    public WebElement getSelectionHeader3() {
        return selectionHeader3;
    }

    public List<WebElement> getBrowserOptions() {
        return browserOptions;
    }

    public WebElement getBrowseViewAllDynamicElement() {
        return browseViewAllDynamicElement;
    }
}
