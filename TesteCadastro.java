package TesteCadastro;

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

public class TesteCadastro {

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
    public void test() throws IOException{
        navegador.manage().window().maximize();
        navegador.get("https://www.youtube.com/");
        navegador.findElement(By.cssSelector(".style-suggestive #text")).click();
        navegador.findElement(By.cssSelector(".NlWrkb")).click();
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        navegador.findElement(By.xpath("//div[@id='initialView']/div[2]/div[2]/div/div/span/div[2]/div")).click();
        navegador.findElement(By.id("firstName")).sendKeys("pula");
        navegador.findElement(By.id("lastName")).sendKeys("nuvens");
        navegador.findElement(By.id("username")).sendKeys("pulanuvensdobem3@gmail.com");
        navegador.findElement(By.name("Passwd")).sendKeys("@PulaNuvens01");
        navegador.findElement(By.name("ConfirmPasswd")).sendKeys("@PulaNuvens01");
        navegador.findElement(By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ > .VfPpkd-RLmnJb")).click();
        String confirmar= navegador.getTitle();
        Assert.assertEquals("Criar sua Conta do Google",confirmar);

        TakesScreenshot ts=(TakesScreenshot) navegador;
        File soucer=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(soucer,new File("./screenshot/login.png"+getDate()));
    }
}


