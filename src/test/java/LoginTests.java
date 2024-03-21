import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests {
    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void PositiveTest(){
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();

        WebElement email = wd.findElement(By.xpath("//input[1]"));
        email.click();
        email.clear();
        email.sendKeys("hanna@g.com");

        WebElement password = wd.findElement(By.xpath("//input[2]"));
        password.click();
        password.clear();
        password.sendKeys("098!7654321$Aa");

        wd.findElement(By.xpath("//button[1]")).click();
        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);

    }
    @Test
    public void NegTestWrongEmail(){
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();

        WebElement email = wd.findElement(By.xpath("//input[1]"));
        email.click();
        email.clear();
        email.sendKeys("hannag.com");

        WebElement password = wd.findElement(By.xpath("//input[2]"));
        password.click();
        password.clear();
        password.sendKeys("098!7654321$Aa");

        wd.findElement(By.xpath("//button[1]")).click();



    }

    @AfterMethod
    public void tearDown(){}
}
