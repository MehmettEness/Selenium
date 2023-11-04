package S05_Xpath_cssselector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CssSelector {
    public static void main(String[] args) throws InterruptedException {
        /*
        SYntax
       1) tagName[attributeName = 'attributeValue' ]
       2) Eğer id ile css locate almak istersek #idattributeDegeri
       3) Eğer class ile css locate almak istersek .classattributeDegeri


       x path ile CSS selector asrasındaki farklar

       1) css selector xpathe göre daha hızlı çalışır
       2) x path ile bir webelement için index ile bunu teke düşürebiliriz.
            fakat css selektör ile rahatça kullanamayız
       3) xpath ile bir tag'a sahip Webelementi sadece texti ile  locate edebliriz. Fakat css ile bunu yapamayız.
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basin
        driver.findElement(By.cssSelector("button[onclick = 'addElement()']")).click();
        Thread.sleep(3500);

        //Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.cssSelector("button[onclick = 'deleteElement()']"));
        if (deleteButton.isDisplayed()){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        //Delete tusuna basin
        Thread.sleep(3500);
        deleteButton.click();

        //"Add/Remove Elements" yazisinin gorunur oldugunu test edin
        WebElement addRemove =  driver.findElement(By.cssSelector("h3"));
        System.out.println(addRemove.isDisplayed() ? "Test Passed" : "Test Failed");
        //sayfayı kapatınız

    }
}
