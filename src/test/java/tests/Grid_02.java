package tests;

import manage.DriverManage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Grid_02 {

    DriverManage driverManage = new DriverManage();
   static WebDriver driver;

   @Test
   public void chromeRemoteTest() {

        driver = driverManage.setUpChromeDriver();
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }

    @Test
    public void firefoxRemoteTest() throws MalformedURLException {

        driver = driverManage.setUpFirefoxDriver();

        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }

    @Test
    void edgeRemoteTest(){

       driver = driverManage.RemoteEdgeDriver();
        driver.get("https://www.ebay.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());



    }



}
