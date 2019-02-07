package com.starwars.objectRepository;

import com.starwars.pageFactory.FilmsPage;
import com.starwars.pageFactory.HomePage;
import com.starwars.pageFactory.SearchResultsPage;
import com.starwars.pageFactory.VideoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ObjectRepo {
    WebDriver driver;
    HomePage homePage;
    FilmsPage filmsPage;
    SearchResultsPage searchResultsPage;
    VideoPage videoPage;

    public ObjectRepo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public HomePage getHomePage() {
        if(homePage == null){
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public FilmsPage getFilmsPage() {
        if(filmsPage == null){
            filmsPage = new FilmsPage(driver);
        }
        return filmsPage;
    }

    public SearchResultsPage getSearchResultsPage() {
        if(searchResultsPage == null){
            searchResultsPage = new SearchResultsPage(driver);
        }
        return searchResultsPage;
    }

    public VideoPage getVideoPage() {
        if(videoPage == null){
            videoPage = new VideoPage(driver);
        }
        return videoPage;
    }
}
