package ru.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CreatedMessage {
    private final By btnSendMessageXpath=By.xpath("//a[@title='Написать (w, c)']");
    private final By recipientMessageXpath=By.xpath("(//div[@class='composeYabbles'])[1]");
    private final By subjectMessageXpath=By.xpath("(//input[@class='composeTextField ComposeSubject-TextField'])[1]");
    private final By messageBodyXpath=By.xpath("//*[@id='cke_292_contents']/div");
    private final By btnSendMessage2Xpath=By.xpath("(//button[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l'])[1]");

    WebDriver driver = new ChromeDriver();
    WebElement btnSendMessage = driver.findElement(btnSendMessageXpath);
    WebElement recipientMessage = driver.findElement(recipientMessageXpath);
    WebElement subjectMessage = driver.findElement(subjectMessageXpath);
    WebElement messageBody = driver.findElement(messageBodyXpath);
    WebElement btnSendMessage2 = driver.findElement(btnSendMessage2Xpath);
    public void createdMessage(String emailRecipient, String subjectMessageForRecipient,int volumeMessage) {
        btnSendMessage.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        recipientMessage.sendKeys(emailRecipient,Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        subjectMessage.sendKeys(subjectMessageForRecipient);
        messageBody.sendKeys(""+volumeMessage);
        btnSendMessage2.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }
}
