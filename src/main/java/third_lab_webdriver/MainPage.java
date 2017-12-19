package third_lab_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainPage
{
    private WebDriver driver;
    static final SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    @FindBy(xpath = "//span[@class='b-toolbar__btn__text b-toolbar__btn__text_pad']")
    private WebElement buttonCreateLetter;

    @FindBy(xpath = "//textarea[@data-original-name='To']")
    private WebElement adresat;

    @FindBy(xpath = "//input[@name='Subject']")
    private WebElement topic;

    @FindBy(xpath = "//iframe")
    private List<WebElement> listFrame;

    @FindBy(id = "tinymce")
    private WebElement bodyLetter;

    @FindBy(xpath = "//span[@class='b-toolbar__btn__text']")
    private WebElement submitLetter;

    @FindBy(xpath = "//a[@id='PH_logoutLink']")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[text()=' отправлено. ']")
    private WebElement messageLettersStatus;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public void sendLetterToPerson(User user)
    {
        buttonCreateLetter.click();
        adresat.click();
        adresat.sendKeys(user.getLogin()+"@mail.ru");
        topic.click();
        topic.sendKeys(dateFormat.format(new Date()));
        driver.switchTo().frame(listFrame.get(0));
        bodyLetter.click();
        bodyLetter.sendKeys("Hello world!");
        driver.switchTo().parentFrame();
        submitLetter.click();
    }


    public boolean checkStatusLetter()
    {
        if (messageLettersStatus.getText().contains("Ваше письмо отправлено. Перейти во Входящие") || messageLettersStatus.isDisplayed()) {
            clickLogoutButton();
            return true;
        } else return false;
    }

    public void clickLogoutButton()
    {
        logoutButton.click();
        driver.close();
    }

}
