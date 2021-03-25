package LoginTeste;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginTest {


    WebDriver navegador;

    @Before
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\jordan.miranda\\AppData\\Local\\Temp\\Temp1_chromedriver_win32.zip\\chromedriver.exe");
        navegador = new ChromeDriver();
    }
    public String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        Date date = new Date();
        return dateFormat.format(date);
    }
    @Test
    public void test() throws IOException {

        navegador.manage().window().maximize();
        navegador.get("https://accounts.google.com/AccountChooser/identifier?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=AccountChooser");
        navegador.findElement(By.cssSelector("#identifierId")).sendKeys("pulanuvensdobem@gmail.com");
        navegador.findElement(By.xpath("//div[@id='identifierNext']/div/button/div[2]")).click();


    }
}
