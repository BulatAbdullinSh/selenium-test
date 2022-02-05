package ru.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.FindMessagePage;
import ru.yandex.pages.LoginPage;

import java.time.Duration;

public class TestFindMessage {
    @Test
    public void findMessage(){

        String login = "jon.s44itt@yandex.ru";
        String password = "31012022@@";
        String messageSubjextXpath = "//span[@title=\'Simbirsoft Тестовое задание\']";
        int volumeMessageExcepted = 3;

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://passport.yandex.ru/");
        LoginPage lp = new LoginPage();
        lp.login(login, password);
        FindMessagePage findVolumeMessage = new FindMessagePage();
        final int volumeMessage = findVolumeMessage.volumeFindMessage(messageSubjextXpath);
        Assert.assertEquals(volumeMessageExcepted, volumeMessage);
        driver.quit();
    }
}
