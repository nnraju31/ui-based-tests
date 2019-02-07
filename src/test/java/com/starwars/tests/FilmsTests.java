package com.starwars.tests;

import com.starwars.baseConfigurations.BaseLoader;
import com.starwars.objectRepository.ObjectRepo;
import com.starwars.pageFactory.FilmsPage;
import com.starwars.pageFactory.HomePage;
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

public class FilmsTests extends BaseLoader {

    ObjectRepo objectRepo;
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = getDriver();
        driver.get("https://www.starwars.com/");
        objectRepo = new ObjectRepo(driver);
        HomePage homePage = objectRepo.getHomePage();
        homePage.getFilms().click();

    }

    @Test(priority = 0)
    public void validationOnHomePage(){
        objectRepo = new ObjectRepo(driver);
        FilmsPage filmsPage = objectRepo.getFilmsPage();

        Assert.assertEquals(driver.getTitle(),"Star Wars Movies | StarWars.com");

        System.out.println(driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement selectorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"film-selector\"]/div/label")));

        Assert.assertEquals(filmsPage.getFilmName1().getText(),"SOLO: A STAR WARS STORY");

        Assert.assertEquals(selectorElement.getText().replaceAll("^\\s+","").replaceAll("\\s+$",""),"STAR WARS FILM SELECTOR");



        Assert.assertEquals(filmsPage.getDefaultSelection().getText(),"SEE ALL");
        filmsPage.getDefaultSelection().click();

        Assert.assertEquals(filmsPage.getAllAvailableSelections().size(),11);

        boolean ispresent = false;

      for(WebElement option: filmsPage.getAllAvailableSelections()){
          if(option.getText().equalsIgnoreCase("A NEW HOPE")){
              ispresent = true;
          }
      }

      Assert.assertTrue(ispresent);


    }

    @AfterClass
    public void shutDownSession(){
        closeDriver(driver);
    }

}
