package S03_WebEelements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebEelementsLocators {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // Google sayfasına gidelim
        driver.get("https://www.google.com");

        // Arama kutusunu "name" attribute e göre bularak "selenium" yazalim
       WebElement searchBox = driver.findElement(By.name("q"));
       searchBox.sendKeys("selenium" , Keys.ENTER);

        // Aramayı yapalim

        //Başlığın selenium içerdiğini test edelim
        String expectualTitle = "selenium";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle.contains(expectualTitle) ? "Test Passed" : "Test Failed");

        //Sayfada kaç tane link olduğunu yazdıralım
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("linklerin sayisi = " + links.size());

        //Sayfadaki linklerin metinleri varsa konsola yazdıralım
        for ( WebElement w  : links ) {
            if (!w.getText().isEmpty()){ //tüm boşlukları kapatır. Yani texti boş olanlar var onları ortadan kaldırmak için bvu şekilde if kullanırız
                System.out.println(w.getText());
            }

        }

        //sayfayı kapatalım
        driver.close();
        /*
        Eğer birden fazla webelementi locate etmek istiyorsak findElements methodu kullanırız.
        Bu method bize elemanlari webelement olan bir list return eder.

        Bir webelemente airt  yazıyı alabilmek için getText () methodu kullanırız.
         */
    }
}
