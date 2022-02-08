package ru.yandex;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.FindMessagePage;

public class TestFindMessage {
    @Test
    public void findMessage(){

        String login = "jon.s44itt@yandex.ru";
        String password = "31012022@@";
        String messageSubjextXpath = "//span[@title='Simbirsoft Тестовое задание']";
        int volumeMessageExcepted = 3;

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        FindMessagePage findVolumeMessage = new FindMessagePage();
        final int volumeMessage = findVolumeMessage.volumeFindMessage(login, password,messageSubjextXpath);
        Assert.assertEquals(volumeMessage,volumeMessageExcepted);
    }
}
