package third_lab_webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{


    private WebDriver driver;

    /**
     * Поле Логин
     */
    @FindBy(id = "mailbox:login")
    private WebElement login;

    /**
     * Поле Пароль
     */
    @FindBy(id = "mailbox:password")
    private WebElement password;

    /**
     * Кнопка Подтверждение
     */
    @FindBy(xpath = "//input[@value='Войти']")
    private WebElement submitButton;

    /**
     * Сообщение об ошибке
     */
    @FindBy(id = "mailbox:error")
    private WebElement messageError;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Авторизация пользователя
     */
    private void logonUser(User user) {
        login.clear();
        login.sendKeys(user.getLogin());
        password.sendKeys(user.getPassword());
        submitButton.click();
    }

    /**
     * Успешная регистрация пользователя
     */
    public MainPage logonUserSuccess(User user) {
        logonUser(user);
        return new MainPage(driver);
    }

    /**
     * Неуспешная регистрация
     */
    public LoginPage registerUserError(User user) {
        logonUser(user);
        return new LoginPage(driver);
    }

    public boolean checkErrorMessage() {
        if (messageError.getText().contains("Неверное имя или пароль") || messageError.isDisplayed())
            return true;
        else return false;
    }
}
