package ru.yandex;
import org.testng.Assert;
import ru.yandex.pages.LoginPage;
import org.testng.annotations.Test;


public class TestLogin {
    @Test
    public void testLogin(){

        String login = "jon.s44itt@yandex.ru";
        String password = "31012022@@";

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        LoginPage lp = new LoginPage();
        lp.login(login, password);
        final String title = lp.title();
        Assert.assertEquals(title, "Авторизация");
    }
}
