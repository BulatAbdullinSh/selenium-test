package ru.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.CreatedMessage;
import ru.yandex.pages.FindMessagePage;
import ru.yandex.pages.LoginPage;

import java.time.Duration;

public class TestCreateMessage {
    @Test
    public void testCreateMessage(){
        String login = "jon.s44itt@yandex.ru";
        String password = "31012022@@";
        String messageSubjextXpath = "//span[@title=\'Simbirsoft Тестовое задание\']";
        String emailRecipient = "jon.s44itt@yandex.ru";
        String subjectMessageForRecipient = "Simbirsoft Тестовое задание Абдуллин";
        String messageSubject = "Simbirsoft Тестовое задание Абдуллин";
        int volumeMessageExcepted = 1;

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://passport.yandex.ru/");
        LoginPage lp = new LoginPage();
        lp.login(login, password);
        FindMessagePage findVolumeMessage = new FindMessagePage();
        final int volumeMessage = findVolumeMessage.volumeFindMessage(messageSubjextXpath);
        CreatedMessage cM = new CreatedMessage();
        cM.createdMessage(emailRecipient,subjectMessageForRecipient,volumeMessage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        FindMessagePage findMessagePage = new FindMessagePage();
        final int volumeFindMessage = findMessagePage.volumeFindMessage(messageSubject);
        Assert.assertEquals(volumeMessageExcepted,volumeFindMessage);
        driver.quit();
    }
}
