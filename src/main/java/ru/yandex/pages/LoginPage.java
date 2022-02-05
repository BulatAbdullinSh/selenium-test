package ru.yandex.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class LoginPage {
    private final By inputEmailXpath = By.xpath("//*[@id='passp-field-login']");
    private final By btnInputXpath = By.xpath("//*[@id='passp:sign-in']");
    private final By inputPasswordXpath = By.xpath("//*[@id='passp-field-passwd']");
    private final By btnInputEmaillXpath=By.xpath("//*[@id='passp:sign-in']");
    WebDriver driver = new ChromeDriver();
    WebElement loginInput = driver.findElement(inputEmailXpath);
    WebElement btnInputAfterEnterEmaill=driver.findElement(btnInputXpath);
    WebElement inputPassword=driver.findElement(inputPasswordXpath);
    WebElement btnInputEmaillAfterPassword = driver.findElement(btnInputEmaillXpath);
        public void login(String login, String password) {
            loginInput.sendKeys(login);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
            btnInputAfterEnterEmaill.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
            inputPassword.sendKeys(password);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
            btnInputEmaillAfterPassword.click();
        }
}
