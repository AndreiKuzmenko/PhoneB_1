package tests;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Registrations extends TestBase{
//    WebDriver wd;
//
//    @BeforeMethod
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }
//@Test
//public void RegPositive(){
//    wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//    int i = (int)(System.currentTimeMillis()/1000)%3600;
//
//    WebElement email = wd.findElement(By.xpath("//input[1]"));
//    email.click();
//    email.clear();
//    email.sendKeys("hanna" + i + "@g.com");
//
//    WebElement password = wd.findElement(By.xpath("//input[2]"));
//    password.click();
//    password.clear();
//    password.sendKeys("098!7654321$Aa");
//
//    wd.findElement(By.xpath("//button[2]")).click();
//    //Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
//    pause(5000);
//    Assert.assertTrue(isElementPresent(By.xpath("//button")));
//}
    @Test
    public void registrationPositive()
    {
        int i = (int)(System.currentTimeMillis()/1000)%3600;
         User user = new User()
                 .withEmail("hanna" + i + "@g.com")
                 .withPassword("098!7654321$Aa")
                 ;
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

@Test
public void NegTestWrong(){
    int i = (int)(System.currentTimeMillis()/1000)%3600;
    String email = "hanna" + i + "g.com", password = "098!7654321$Aa";
       app.getUser().openLoginForm();
       app.getUser().fillLoginForm(email, password);
       app.getUser().submitRegistration();


}

@Test
public void NegTestWrongPassword(){

    String email = "hanna@g.com", password = "----------123-------";
    app.getUser().openLoginForm();
    app.getUser().fillLoginForm(email, password);
    app.getUser().submitRegistration();

}
    @AfterMethod
    public void tearDown(){}
}
