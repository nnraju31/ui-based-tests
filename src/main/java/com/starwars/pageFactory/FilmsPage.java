package com.starwars.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilmsPage {

    WebDriver driver;

    public FilmsPage(WebDriver driver) {
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

    @FindBy(xpath = "//*[@id=\"film-selector\"]/div/label") private WebElement filmSelectortext;
    @FindBy(xpath = "//*[@id=\"film-selector\"]/div/div/label") private WebElement defaultSelection;
    @FindBy(xpath = "//*[@id=\"film-selector\"]/div/ul/li") private List<WebElement> allAvailableSelections;



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

    public WebElement getFilmSelectortext() {
        return filmSelectortext;
    }

    public WebElement getDefaultSelection() {
        return defaultSelection;
    }

    public List<WebElement> getAllAvailableSelections() {
        return allAvailableSelections;
    }


}
