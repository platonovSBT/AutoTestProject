package third_lab_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MyWebDriver
{
    private static WebDriver driver;

    private static WebElement loginTextbox, pwdTextbox, enterButton, writeLetterButton;

    private static final String url="https://mail.ru/";

    private static final String login="ashot.akapyan1975";

    private static final String pwd="pwd1234567890";

    private static final String pathToDriver="C:\\Users\\sbt-platonov-aa\\myProgramm\\Java\\IEdriver\\IEDriverServer.exe";

    private static SimpleDateFormat dateFormat;

    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public static void setDateFormat(SimpleDateFormat dateFormat) {
        MyWebDriver.dateFormat = dateFormat;
    }

    private static void loginUser(String name, String password)
    {
        loginTextbox=driver.findElement(By.xpath("//input[@id='mailbox:login']"));
        loginTextbox.clear();
        loginTextbox.sendKeys(name);

        pwdTextbox=driver.findElement(By.xpath("//input[@id='mailbox:password']"));
        pwdTextbox.sendKeys(password);

        enterButton=driver.findElement(By.xpath("//input[@value='Войти']"));
        enterButton.click();
    }

    private static void clickButtonWriteLetter()
    {
        writeLetterButton=driver.findElement(By.xpath("//span[@class='b-toolbar__btn__text b-toolbar__btn__text_pad']"));
        writeLetterButton.click();
    }

    private static void logoutUser()
    {
        driver.findElement(By.xpath("//a[@id='PH_logoutLink']")).click();
    }

    private static void writeLetter(String message)
    {
        //Заполнение поля Адресат
        driver.findElement(By.xpath("//textarea[@data-original-name='To']")).click();
        driver.findElement(By.xpath("//textarea[@data-original-name='To']")).sendKeys(login+"@mail.ru");

        //Заполнение поля Тема
        driver.findElement(By.xpath("//input[@name='Subject']")).click();
        driver.findElement(By.xpath("//input[@name='Subject']")).sendKeys(getDateFormat().format( new Date() ));

        //Заполнение тела письма
        driver.switchTo().frame(driver.findElements(By.xpath("//iframe")).get(0));
        driver.findElement(By.xpath("//*[@id='tinymce']")).click();
        driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys(message);
        driver.switchTo().parentFrame();

        //Нажатие кнопки отправить
        driver.findElement(By.xpath("//span[@class='b-toolbar__btn__text']")).click();
    }

    private static String checkLetterStatus()
    {
        boolean flag;
        String answer;
        flag=driver.findElement(By.xpath("//*[text()=' отправлено. ']")).isEnabled();
        if (flag=true)
        {
            answer="Сообщение успешно отправлено!";
        }
        else answer="Сообщение не отправлено!";
        return answer;
    }

    public static void main(String[] args) {

        System.setProperty("webdriver.ie.driver", pathToDriver);

        driver=new InternetExplorerDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get(url);

        loginUser(login,pwd);

        clickButtonWriteLetter();

        setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));

        writeLetter("Hello");

        System.out.println(checkLetterStatus());

        logoutUser();

        driver.close();
    }


}