package third_lab_webdriver;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class MyWebDriverTest {
    static WebDriver driver;
    static String   url, login, pwd, pathToDriver;
   static final SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");



    @BeforeClass
    public static void initialise() throws IOException {
        Properties conf = new Properties();
        conf.load(new FileInputStream(new File("config/properties.ini")));
        url = conf.getProperty("url");
        login = conf.getProperty("login"); //набор
        pwd = conf.getProperty("pwd");   //набор
        pathToDriver = conf.getProperty("pathToDriver");
        System.setProperty("webdriver.ie.driver", pathToDriver);

        driver =new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void LogonUser_LoginAndPwd_LogonDone( ) {
        driver.findElement(By.xpath("//input[@id='mailbox:login']")).clear();
        driver.findElement(By.xpath("//input[@id='mailbox:login']")).sendKeys(login);

        driver.findElement(By.xpath("//input[@id='mailbox:password']")).sendKeys(pwd);

        driver.findElement(By.xpath("//input[@value='Войти']")).click();

        Assert.assertTrue("Операция Авторизация прошла успешно!", driver.findElement(By.xpath("//span[@class='b-toolbar__btn__text b-toolbar__btn__text_pad']")).isEnabled());
    }

    @Test
    public void SendMessage_UsersWroteLetterAndSent_LetterGone() {
        //Нажатие кнопки 'Создать Письмо'
        driver.findElement(By.xpath("//span[@class='b-toolbar__btn__text b-toolbar__btn__text_pad']")).click();

        //Заполнение поля Адресат
        driver.findElement(By.xpath("//textarea[@data-original-name='To']")).click();
        driver.findElement(By.xpath("//textarea[@data-original-name='To']")).sendKeys(login + "@mail.ru");

        //Заполнение поля Тема
        driver.findElement(By.xpath("//input[@name='Subject']")).click();
        driver.findElement(By.xpath("//input[@name='Subject']")).sendKeys(dateFormat.format(new Date()));

        //Заполнение тела письма
        driver.switchTo().frame(driver.findElements(By.xpath("//iframe")).get(0));
        driver.findElement(By.xpath("//*[@id='tinymce']")).click();
        driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("Hello World! ");
        driver.switchTo().parentFrame();

        //Нажатие кнопки отправить
        driver.findElement(By.xpath("//span[@class='b-toolbar__btn__text']")).click();

        Assert.assertTrue("Письмо успешно отправлено!", driver.findElement(By.xpath("//*[text()=' отправлено. ']")).isEnabled());

    }


    @AfterClass
    public static void logoutUser() {
        driver.findElement(By.xpath("//a[@id='PH_logoutLink']")).click();
        driver.close();
    }
}
