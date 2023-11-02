package S03_WebEelements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locators {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com");

        //Arama kutusunu locate ediniz ve iphone yazdırıp aratınız
      //  WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
       // aramaKutusu.sendKeys("iphone");
       // aramaKutusu.submit();

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //sayfayı kapatınız.
        driver.close();
    }
}
