package S05_Xpath_cssselector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("button[type='button']")).click();

        //Login alanine  "username" yazdirin

        //Password alanine "password" yazdirin

        //Sign in buttonuna tiklayin
        WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
        login.sendKeys("username" , Keys.TAB , "password" , Keys.ENTER);
        Thread.sleep(3500);
        driver.navigate().back(); // sayfa log in olduğunda güvenlik uyarısını aşmak için bac kullandık sonrasında login oldu

        //Online Banking altındaki Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("li[id='onlineBankingMenu']")).click();
        Thread.sleep(3500);
        driver.findElement(By.xpath("//span[.='Pay Bills']")).click();
        Thread.sleep(3500);

        //amount kismina yatirmak istediginiz herhangi bir miktari yazin


        //tarih kismina "2020-09-10" yazdirin

        //Pay buttonuna tiklayin

        WebElement amount = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amount.sendKeys("500" , Keys.TAB , "2020-09-10" , Keys.TAB , Keys.TAB  , Keys.ENTER);

        //"The payment was successfully submitted." mesajinin ciktigini control edin
        WebElement message = driver.findElement(By.xpath("//span[1]"));
        String actualSuccesMessage = message.getText();
        String expectedSuccesmesdsage = "The payment was successfully submitted.";
        System.out.println(actualSuccesMessage.equals(expectedSuccesmesdsage) ? "Test Passed" : "Test Failed");


        //sayfayı kapatınız
        driver.close();


    }
}
