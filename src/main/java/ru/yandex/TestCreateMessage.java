package ru.yandex;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.CreatedMessage;

public class TestCreateMessage {
    @Test
    public void testCreateMessage(){
        String login = "jon.s44itt@yandex.ru";
        String password = "31012022@@";
        String emailRecipient = "jon.s44itt@yandex.ru";
        String subjectMessageForRecipient = "Simbirsoft Тестовое задание Абдуллин";
        String volumeMessageExcepted = "Письмо отправлено";

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        CreatedMessage cM = new CreatedMessage();
        final String volumeMessage = cM.createdMessage(login, password, emailRecipient, subjectMessageForRecipient);
        Assert.assertEquals(volumeMessageExcepted,volumeMessage);
    }
}
