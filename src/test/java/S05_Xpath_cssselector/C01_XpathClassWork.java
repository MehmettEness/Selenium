package S05_Xpath_cssselector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XpathClassWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basin
        driver.findElement(By.xpath("//*[contains (text(),'Add Ele')]")).click();
        Thread.sleep(3500);

        //Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//*[.='Delete']"));
        if (deleteButton.isDisplayed()){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        //Delete tusuna basin
        Thread.sleep(3500);
        deleteButton.click();

        //"Add/Remove Elements" yazisinin gorunur oldugunu test edin
       WebElement addRemove =  driver.findElement(By.xpath("//h3"));
        System.out.println(addRemove.isDisplayed() ? "Test Passed" : "Test Failed");
        //sayfayı kapatınız

    }
}
