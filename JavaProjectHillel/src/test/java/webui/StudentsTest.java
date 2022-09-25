package webui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class StudentsTest {
    private WebDriver driver;

    private WebDriverWait wait;


    @BeforeSuite
    public void init() {
        System.setProperty("webdriver.chrome.driver", "/Users/gotsman/Downloads/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //ждун
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://151.80.70.42:3000");
    }

//    @AfterSuite
//    public void close() {
//        driver.close();
//    }



//
//    @BeforeTest
//    public void cleanUp() {
//
//        var users = driver.findElements(By.cssSelector("#user-list >li"));
//
//        for (var user : users) {
////            var name = user.findElement(By.cssSelector("h4")).getText();
////            System.out.println(name);
//            user.findElement(By.cssSelector(".remove")).click();
//            var alert = wait.until(ExpectedConditions.alertIsPresent());
//            alert.accept();
//        }
//
//    }



    @Test
    public void remove() {
        var users = driver.findElements(By.cssSelector("#user-list >li"));

        for (var user : users) {
            if (user.findElement(By.tagName("h4")).getText().contains("Java")) {

                user.findElement(By.cssSelector(".remove")).click();
                var alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
            }
        }

    }


    private void createStudent(String name, String phone) {
        driver.findElement(By.cssSelector("i.mdi-content-add")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.main-content")));
        driver.findElement(By.cssSelector("div.main-content #icon_prefix")).clear();
        driver.findElement(By.cssSelector("div.main-content #icon_prefix")).sendKeys(name);
        driver.findElement(By.cssSelector("div.main-content #icon_telephone")).clear();
        driver.findElement(By.cssSelector("div.main-content #icon_telephone")).sendKeys(phone);
        driver.findElement(By.cssSelector("div.main-content a.save-btn")).click();

        wait.until(ExpectedConditions
                .visibilityOf(driver.findElement(By.cssSelector("#user-list >li.active"))));

    }

    @Test
    public void createStudentTest(){

        createStudent("Kevin", "7463536272");
        createStudent("Bob", "09864738238");
        createStudent("Stuart", "637281535");
        createStudent("Java", "8.8.8.8");
    }



    //private void createSupport(String name, String phone, String city) {}

}


//    public void waitForLoad(WebDriver driver) {
//        ExpectedCondition<Boolean> pageLoadCondition = new
//                ExpectedCondition<Boolean>() {
//                    public Boolean apply(WebDriver driver) {
//                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
//                    }
//                };
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(pageLoadCondition);
//    }


