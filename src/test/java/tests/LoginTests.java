package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
//    WebDriver wd;
//
//    @BeforeMethod
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }
    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
     public void PositiveTestBase(){
        String email = "hanna@g.com", password = "098!7654321$Aa";
        app.getUser(). openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
//        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }
    @Test
    public void NegTestWrongEmail(){
        String email = "hannag.com", password = "098!7654321$Aa";
        app.getUser(). openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(3000);




    }
    @Test
    public void NegTestWrongEmailNew() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "hanna" + i + "@@@g.com", password = "098!7654321$Aa";
        openLoginForm();
        fillLoginForm(email, password);
        submitLogin();
    }
    @AfterMethod
    public void tearDown(){}
}
