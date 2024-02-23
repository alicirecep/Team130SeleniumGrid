package tests;

import org.testng.annotations.*;

import static manage.DriverManage.*;

public class Grid_03 {

    @BeforeTest
    @Parameters ("browser")
    void beforeTest(@Optional ("grid_chrome") String browser){
        setDriver(browser);
    }


    @Test
    void Test01(){

        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }

    @AfterTest
    void afterTest(){
        closeDriver();
    }

}
