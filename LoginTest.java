package LoginTeste;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
        navegador.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
        navegador.findElement(By.xpath("//input[@name='password']")).sendKeys("@PulaNuvens01    ");
        try {Thread.sleep(10000);}catch (Exception erro){}
        navegador.findElement(By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ > .VfPpkd-RLmnJb")).click();
        try {Thread.sleep(10000);}catch (Exception erro){}
        navegador.findElement(By.cssSelector(".gb_Da")).click();
        navegador.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
        String validacao =navegador.findElement(By.cssSelector(".gb_mb")).getText();
        Assert.assertEquals("Pula Nuvens",validacao);

        TakesScreenshot ts=(TakesScreenshot) navegador;
        File soucer=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(soucer,new File("./screenshot/login.png"+getDate()));




    }
}
