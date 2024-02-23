package tests;

import com.google.common.annotations.VisibleForTesting;
import manage.DriverManage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Grid_01 {

   static WebDriver driver;

   DriverManage driverManage = new DriverManage();


    public static void main(String[] args) throws MalformedURLException {


        driver = new RemoteWebDriver(new URL("http://192.168.0.163:4444"), new ChromeOptions());
// Bu satirda desired capabilities olarak biz bir tercihte bulunmadik. NODE'da var olan operation system
// ve driver ne varsa onunla calis dedik.

        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

    }


    @Test
    void firefoxTest() throws MalformedURLException {

        driver = new RemoteWebDriver(new URL("http://192.168.0.163:4444"), new FirefoxOptions());

        driver.get("https://www.google.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

}

    @Test
    public void chromeTest() {

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


}
