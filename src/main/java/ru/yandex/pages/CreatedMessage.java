package ru.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CreatedMessage {
    WebDriver driver = new ChromeDriver();
    public String createdMessage(String login, String password, String emailRecipient, String subjectMessageForRecipient) {
        driver.get("https://mail.yandex.ru/");
        driver.findElement(By.xpath("//a[@class='control button2 button2_view_classic button2_size_mail-big button2_theme_mail-white button2_type_link HeadBanner-Button HeadBanner-Button-Enter with-shadow']")).click();
        driver.findElement(By.xpath("//*[@id='passp-field-login']")).sendKeys(login);
        driver.findElement(By.xpath("//*[@id='passp:sign-in']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.findElement(By.xpath("//*[@id='passp-field-passwd']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='passp:sign-in']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        List<WebElement> findMessage = driver.findElements(By.xpath("//span[@title='Simbirsoft Тестовое задание']"));
        final int volumeMessage = findMessage.size();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.findElement(By.xpath("//a[@title='Написать (w, c)']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.findElement(By.xpath("(//div[@class='composeYabbles'])[1]")).sendKeys(emailRecipient,Keys.ENTER);
        driver.findElement(By.xpath("(//input[@class='composeTextField ComposeSubject-TextField'])[1]")).sendKeys(subjectMessageForRecipient);
        driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/div/div")).sendKeys(""+volumeMessage);
        driver.findElement(By.xpath("(//button[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l'])[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver.findElement(By.xpath("//span[text()='Письмо отправлено']")).getText();
    }
}
