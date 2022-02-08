package ru.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindMessagePage {
    WebDriver driver = new ChromeDriver();

        public int volumeFindMessage(String login, String password, String messageSubject) {
            driver.get("https://mail.yandex.ru/");
            driver.findElement(By.xpath("//a[@class='control button2 button2_view_classic button2_size_mail-big button2_theme_mail-white button2_type_link HeadBanner-Button HeadBanner-Button-Enter with-shadow']")).click();
            driver.findElement(By.xpath("//*[@id='passp-field-login']")).sendKeys(login);
            driver.findElement(By.xpath("//*[@id='passp:sign-in']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
            driver.findElement(By.xpath("//*[@id='passp-field-passwd']")).sendKeys(password);
            driver.findElement(By.xpath("//*[@id='passp:sign-in']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
            List<WebElement> findMessage = driver.findElements(By.xpath(messageSubject));
            return findMessage.size();
        }
    }
