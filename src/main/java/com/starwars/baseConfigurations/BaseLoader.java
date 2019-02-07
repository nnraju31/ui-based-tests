package com.starwars.baseConfigurations;

import com.starwars.enums.DriverType;

import com.starwars.enums.MachineType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseLoader {

    private WebDriver driver;
    private Properties props;
    private DriverType driverType;
    private MachineType machineType;
    private static final String chromeProperty = "webdriver.chrome.driver";

    private final String propertyFilePath = "/src/main/resources/configFiles/global.properties";

    public BaseLoader() {
        try {
            props = new Properties();
            FileInputStream input = new FileInputStream(
                    System.getProperty("user.dir") +propertyFilePath);
            props.load(input);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            throw  new RuntimeException("configuration property not found at" +propertyFilePath);
        }catch (IOException e1) {
            e1.printStackTrace();
        }
        driverType = getBrowser();
        machineType = getmachineType();

    }

    public  long getImplicitWait() {
        String implicitwait = props.getProperty("ImplicitWait");
        if(implicitwait!=null) {
            return Long.parseLong(implicitwait);
        }else{
            throw new RuntimeException("implicit wait time not specified in properties file");
        }
    }

    public DriverType getBrowser(){

        String implicitwait = props.getProperty("Browser");
        switch (implicitwait) {
            case "chrome": return DriverType.CHROME;
            case "ie": return DriverType.INTERNETEXPLORER;
            default: return DriverType.CHROME;
        }

    }

    public MachineType getmachineType(){

        String machineType = props.getProperty("Testmachine");
        switch (machineType) {
            case "local": return MachineType.LOCAL;
            case "remote": return MachineType.REMOTE;
            default: return MachineType.LOCAL;
        }

    }

    public  WebDriver getDriver(){

        if(driverType.equals(DriverType.CHROME) && machineType.equals(MachineType.LOCAL)){
            System.setProperty(chromeProperty,"src/main/resources/driver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(getImplicitWait(), TimeUnit.SECONDS);
            return driver;

        }else if(driverType.equals(DriverType.INTERNETEXPLORER) && machineType.equals(MachineType.LOCAL)){
            throw new RuntimeException("not Implement yet");
        }else{
            throw new RuntimeException("ie is not implemented yet");
        }

    }

    public static void  closeDriver(WebDriver driver){
        driver.quit();
    }
}
