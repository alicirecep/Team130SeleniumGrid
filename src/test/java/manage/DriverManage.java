package manage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManage {

   public static WebDriver driver;

   DesiredCapabilities capabilities = new DesiredCapabilities();


   public WebDriver setUpChromeDriver(){

       capabilities.setPlatform(Platform.WINDOWS);
       capabilities.setBrowserName("chrome");
      capabilities.setVersion("122.0.6261.58");

       ChromeOptions chromeOptions = new ChromeOptions();
       chromeOptions.merge(capabilities);

       try {
           driver = new RemoteWebDriver(new URL("http://192.168.0.163:4444"),chromeOptions);
       } catch (MalformedURLException e) {
           throw new RuntimeException(e);
       }

        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       System.out.println("***** Remote Chrome Driver *****");

       return driver;
   }


    public WebDriver setUpFirefoxDriver() throws MalformedURLException {

        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName("Firefox");
        capabilities.setVersion("121.0.6167.185");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.merge(capabilities);

        driver = new RemoteWebDriver(new URL("http://192.168.0.163:4444"),firefoxOptions);

        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        System.out.println("***** Remote Firefox Driver *****");

        return driver;
    }



    public static void setDriver(String browser) {

        switch (browser){

            case "grid_chrome" : {

                ChromeOptions chromeOptions = new ChromeOptions();
                try {
                    driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("url")), chromeOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(" ****** Selenium Grid Chrome");
                break;
            }

            case "grid_firefox": {

                FirefoxOptions firefoxOptions = new FirefoxOptions();

                try {
                    driver=  new RemoteWebDriver( new URL(ConfigReader.getProperty("url")), firefoxOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(" ****** Selenium Grid Firefox");
                break;
            }

            case "grid_edge" : {

                EdgeOptions edgeOptions = new EdgeOptions();
                try {
                    driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("url")), edgeOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(" ****** Selenium Grid Edge");
                break;
            }

            case "grid_IE": {

                InternetExplorerOptions IEOptions = new InternetExplorerOptions();

                try {
                    driver=  new RemoteWebDriver( new URL(ConfigReader.getProperty("url")), IEOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(" ****** Selenium Grid IE");
                break;
            }

            case "chrome": {
                WebDriverManager.chromedriver().browserVersion("114.0.5735.90").setup();


                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                System.out.println("°°°°° Chrome WebDriver °°°°°°");
                break;
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                System.out.println("°°°°° Firefox WebDriver °°°°°°");
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                System.out.println("°°°°° Edge WebDriver °°°°°°");
                break;
            }
            case "IE": {
                WebDriverManager.iedriver().setup();
                driver = new EdgeDriver();
                System.out.println("°°°°° IE WebDriver °°°°°°");
                break;
            }
            default: {
                WebDriverManager.chromedriver().setup();
                System.out.println("°°°°° Default Chrome WebDriver °°°°°°");
                driver = new ChromeDriver();
            }
        }
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }


    public static void closeDriver(){

        if(driver!= null){
            driver.close();
        }
    }






}
