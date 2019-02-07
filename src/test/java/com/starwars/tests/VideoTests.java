package com.starwars.tests;

import com.starwars.baseConfigurations.BaseLoader;
import com.starwars.objectRepository.ObjectRepo;
import com.starwars.pageFactory.HomePage;
import com.starwars.pageFactory.VideoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class VideoTests extends BaseLoader {

    ObjectRepo objectRepo;
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = getDriver();
        driver.get("https://www.starwars.com/");
        objectRepo = new ObjectRepo(driver);
        HomePage homePage = objectRepo.getHomePage();
        homePage.getVideo().click();
    }

    @Test(priority = 0)
    public void validationOnHomePage(){

        VideoPage videoPage = objectRepo.getVideoPage();

        System.out.println(driver.getTitle());

        Assert.assertEquals(driver.getTitle(),"Star Wars Videos and Behind the Scenes Featurettes | StarWars.com");

        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement browseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ref-1-5\"]/div[1]/div[1]/h2")));

        Assert.assertEquals(videoPage.getSearchTextBox().getAttribute("placeholder"),"Search Star Wars");

        Assert.assertEquals(videoPage.getSelectionHeader1().getText(),"THE STAR WARS SHOW //");
        Assert.assertEquals(videoPage.getSelectionHeader2().getText(),"OUR STAR WARS STORIES //");
        Assert.assertEquals(videoPage.getSelectionHeader3().getText(),"FEATURED VIDEOS //");
        Assert.assertEquals(videoPage.getSelectionHeader4().getText(),"SCIENCE AND STAR WARS //");
        Assert.assertEquals(videoPage.getSelectionHeader5().getText(),"BROWSE VIDEOS //");



        driver.manage().window().maximize();

        Assert.assertEquals(videoPage.getBrowserOptions().size(),18);

        boolean ispresent = false;
        for(WebElement option: videoPage.getBrowserOptions()){
            if(option.getText().equalsIgnoreCase("EPISODE II")){
                ispresent = true;
            }
        }

        Assert.assertTrue(ispresent);

        videoPage.getSearchTextBox().sendKeys("THE");

        Assert.assertTrue(videoPage.getBrowseViewAllDynamicElement().isDisplayed());

        System.out.println(videoPage.getBrowseViewAllDynamicElement().isDisplayed());

    }

    @AfterClass
    public void shutDownSession(){
        closeDriver(driver);
    }

}
