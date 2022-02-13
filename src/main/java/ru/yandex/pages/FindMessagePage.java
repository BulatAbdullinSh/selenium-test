package ru.yandex.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class FindMessagePage {
    @FindBy(xpath = "//span[@title='Simbirsoft Тестовое задание']")
    private List<WebElement> searchMessageSubject;

    public int countFindMessage() {
        return searchMessageSubject.size();
    }
}
