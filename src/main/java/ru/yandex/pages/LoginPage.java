package ru.yandex.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "//a[contains(@class,'Enter with-shadow')]")
    private WebElement btnInputFirst;
    @FindBy(xpath = "//*[@id='passp-field-login']")
    private WebElement inputLogin;
    @FindBy(xpath = "//*[@id='passp:sign-in']")
    private WebElement btnInputMain;
    @FindBy(xpath = "//*[@id='passp-field-passwd']")
    private WebElement inputPassword;

    public void login(String login,String password) {
        btnInputFirst.click();
        inputLogin.sendKeys(login);
        btnInputMain.click();
        inputPassword.sendKeys(password);
        btnInputMain.click();
    }
}
