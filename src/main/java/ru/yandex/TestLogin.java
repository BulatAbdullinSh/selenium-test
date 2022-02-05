package ru.yandex;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import ru.yandex.pages.LoginPage;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLogin {
    @Test
    public void testLogin(){

        String login = "jon.s44itt@yandex.ru";
        String password = "31012022@@";

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://passport.yandex.ru/");
        LoginPage lp = new LoginPage();
        lp.login(login, password);
        String title = driver.getTitle();
        Assert.assertEquals(title, "1 · Входящие — Яндекс.Почта");
        driver.quit();
    }
}
