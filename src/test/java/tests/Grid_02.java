package tests;

import manage.DriverManage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Grid_02 {

    DriverManage driverManage = new DriverManage();
   static WebDriver driver;

   @Test
   public void chromeTest() {

        driver = driverManage.setUpChromeDriver();
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }





}
