package S04_Webwlwmnts_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://testcenter.techproeducation.com/index.php adresine gidin
        driver.get("https://testcenter.techproeducation.com");

        // "Back to TechProEducation.com" butonunun kullanici erisimi icin etkin olup olmadigini test edin
        WebElement backTo = driver.findElement(By.partialLinkText("Back to TechProEducation.com"));
        System.out.println(backTo.isEnabled() ? "Test Passed" : "Test Failed");

        // "Applications lists" basligini tagname ile locate ederek görünür  olup olmadigini test ediniz
        WebElement h1Tag  = driver.findElement(By.tagName("h1"));
        if (h1Tag.isDisplayed()){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        driver.close();
    }
}
