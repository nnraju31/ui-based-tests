package com.starwars;

import com.starwars.baseConfigurations.BaseLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test12 extends BaseLoader {

   @Test
    public void test(){
        WebDriver driver = getDriver();
        driver.get("https://www.wellsfargo.com/");
    }
}
