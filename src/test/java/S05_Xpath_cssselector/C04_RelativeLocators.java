package S05_Xpath_cssselector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C04_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        //Berlin'i relative locator ile locate edin
        WebElement NYC = driver.findElement(By.xpath("//img[@id='pid3_thumb']"));
        WebElement BayArea = driver.findElement(By.cssSelector("#pid8_thumb"));
        WebElement Berlin = driver.findElement(with(By.tagName("img")).below(NYC).toLeftOf(BayArea)); //img almamızın nedeni hepsinde imgnin olması
        Berlin.click();
        Thread.sleep(3500);

        //Relative locator'larin dogru calistigini test edin
       String actualIdDegeri= Berlin.getAttribute("id");
       String expectedIdDegeri = "pid7_thumb";
        System.out.println(actualIdDegeri.equals(expectedIdDegeri) ? "Test Passed" : "Test Failed");

Thread.sleep(3500);
        //sayfayı kapatınız
        driver.close();
    }
}
