package ru.yandex;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class GridTest {
    public WebDriver driver;

    @BeforeTest
    private void setUp() throws MalformedURLException
    {
        DesiredCapabilities dCap=new DesiredCapabilities();
        dCap.setBrowserName("chrome");
        dCap.setPlatform(Platform.WIN10);
        driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dCap);
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
