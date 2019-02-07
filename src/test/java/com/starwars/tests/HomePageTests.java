package com.starwars.tests;

import com.starwars.baseConfigurations.BaseLoader;
import com.starwars.objectRepository.ObjectRepo;
import com.starwars.pageFactory.HomePage;
import com.starwars.pageFactory.SearchResultsPage;
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

public class HomePageTests extends BaseLoader {

    ObjectRepo objectRepo;
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = getDriver();
        driver.get("https://www.starwars.com/");
    }

    @Test(priority = 0)
    public void validationOnHomePage(){
        objectRepo = new ObjectRepo(driver);
        HomePage homePage = objectRepo.getHomePage();

        Assert.assertEquals(driver.getTitle(),"StarWars.com | The Official Star Wars Website");

        Assert.assertTrue(homePage.getFaceBookIcon().isDisplayed(),"valdiating presence of faceBoook Icon");
        Assert.assertTrue(homePage.getSignUP().isDisplayed(),"valdiating presence of signUp ");
        Assert.assertTrue(homePage.getLogin().isDisplayed(),"valdiating presence of login ");
        driver.manage().window().maximize();

        homePage.getSearchTextBox().sendKeys("ACCD");

        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement viewAllDynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-ac\"]/li[6]/a")));
        List<WebElement> numberOfBropdowpShown = driver.findElements(By.xpath("//*[@id=\"nav-ac\"]/li"));
        Assert.assertEquals(numberOfBropdowpShown.size(),6,"valdiating total number of dropdown elements for ACCD search");


        viewAllDynamicElement.click();


    }

    @Test(priority = 1)
    public void valdiationOnSearch(){

        SearchResultsPage searchResultsPage = objectRepo.getSearchResultsPage();

        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement totalSearchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[1]/h2/strong[1]")));
        System.out.println(totalSearchResults.getText());
        Assert.assertEquals(searchResultsPage.getTotalSearchResults(),"53","valdiating total number of dropdown elements for ACCD search");

        Assert.assertEquals(searchResultsPage.getNumberOfSearchResultsinFirstPage(),18,"valdiating total number of dropdown elements for ACCD search");
        System.out.println(driver.getCurrentUrl());

    }

    @AfterClass
    public void shutDownSession(){
        closeDriver(driver);
    }
}
