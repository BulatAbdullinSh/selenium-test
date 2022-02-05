package ru.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindMessagePage {

        WebDriver driver = new ChromeDriver();

        public int volumeFindMessage(String messageSubject) {
            List<WebElement> findMessage = driver.findElements(By.xpath(messageSubject));
            final int volumeMesssage = findMessage.size();
            return volumeMesssage;
        }
    }
