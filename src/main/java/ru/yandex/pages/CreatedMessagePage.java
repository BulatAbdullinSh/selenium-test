package ru.yandex.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatedMessagePage {
    @FindBy(xpath = "//a[@title='Написать (w, c)']")
    private WebElement btnWriteMessage;
    @FindBy(xpath = "(//div[@class='composeYabbles'])[1]")
    private WebElement itemEmaillRecipient;
    @FindBy(xpath = "//input[contains(@class,'ComposeSubject')]")
    private WebElement itemMessageSubject;
    @FindBy(xpath = "//div[contains(@class,'cke_editable')]")
    private WebElement itemBodyMessage;
    @FindBy(xpath = "//button[contains(@class,'view_default Button2_size_l')]")
    private WebElement btnSendMessage;
    @FindBy(xpath = "//span[text()='Письмо отправлено']")
    private WebElement itemStatusSendMessage;

    public String createdMessage(String emailRecipient, String subjectMessageForRecipient, int volumeFindMessage) {
        btnWriteMessage.click();
        itemEmaillRecipient.sendKeys(emailRecipient, Keys.ENTER);
        itemMessageSubject.sendKeys(subjectMessageForRecipient);
        itemBodyMessage.sendKeys("" + volumeFindMessage);
        btnSendMessage.click();
        return itemStatusSendMessage.getText();
    }
}