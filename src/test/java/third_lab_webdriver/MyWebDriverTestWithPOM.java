package third_lab_webdriver;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MyWebDriverTestWithPOM
{
    private static WebDriver driver;
    private static String pathToDriver;
    private static User user;
    @BeforeClass
    public static void initialise() throws IOException {
        Properties conf = new Properties();
        conf.load(new FileInputStream(new File("config/properties.ini")));
        user=new User();
        user.setUrl(conf.getProperty("url"));
        user.setLogin( conf.getProperty("login"));
        user.setPassword( conf.getProperty("pwd"));

        pathToDriver = conf.getProperty("pathToDriver");
        System.setProperty("webdriver.ie.driver", pathToDriver);

        driver =new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(user.getUrl());
    }



    @Test
    public void LoginPage_LogonUser_LogonSuccess( ) {
        LoginPage loginPage=new LoginPage(driver);
        Assert.assertFalse("Операция Авторизация провалилась!",
                loginPage.registerUserError(user).checkErrorMessage());

    }

    @Test
    public void MainPage_SendLetterToPerson_LetterSent( ) {
        MainPage mainPage=new MainPage(driver);
        mainPage.sendLetterToPerson(user);

        Assert.assertTrue("Операция Отправки Письма провалилась!",
                mainPage.checkStatusLetter());

    }



    @AfterClass
    public static void exitDriver() {
        driver.close();
    }
}
