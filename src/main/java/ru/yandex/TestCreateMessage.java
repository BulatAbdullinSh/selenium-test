package ru.yandex;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.CreatedMessagePage;
import ru.yandex.pages.FindMessagePage;
import ru.yandex.pages.LoginPage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestCreateMessage extends WebDriverSetting {
    String emailRecipient = "jon.s44itt@yandex.ru";
    String subjectMessageForRecipient = "Simbirsoft Тестовое задание Абдуллин";
    String statusMessageSendExpected = "Письмо отправлено";
    FileInputStream fis;
    Properties prop = new Properties();

    {
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateMessage() throws IOException {
        prop.load(fis);
        driver.get(prop.getProperty("site"));
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        final String login = prop.getProperty("login");
        final String password = prop.getProperty("password");
        loginPage.login(login, password);
        FindMessagePage findMessagePage = PageFactory.initElements(driver, FindMessagePage.class);
        final int volumeFindMessage = findMessagePage.countFindMessage();
        CreatedMessagePage createdMessagePage = PageFactory.initElements(driver, CreatedMessagePage.class);
        final String ActualStatusMessage = createdMessagePage.createdMessage(emailRecipient, subjectMessageForRecipient, volumeFindMessage);
        Assert.assertEquals(statusMessageSendExpected, ActualStatusMessage);
    }
}
