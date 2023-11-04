package S04_Webwlwmnts_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_XPATH {
    public static void main(String[] args) throws InterruptedException {
        //X Path

        /*
        / => bu direkt bir cocugu secer
            /html/body


        //=> Bu belgenin herhangi bir yerindeki bir elementi secmek icin kullanilir
            //div

        @ => Bir webelmentin attributee unu secmek icin kullanilir
            //input[@name='field-keywords']

        []=> kosullar veya index belirtmek icin kullanilir
            //input [2]

        * Hepsini secer

        SYNTAX

        //tagname [@attributeName ='attributeDegeri']
        //* [@* = 'attributedegeri' ]
        -> eger bu kullanimda birden fazla sonuc verirse * koydugumuz yerlere tagname ve attributename i belirtebiliriz
        -> buna ragmen birden fazla sonuc verirse o webelementin indexini asagidaki sekilde alabiliriz

        (//tagname [@attributeName ='attributeDegeri']) [index]

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com");



        //Arama kutusunda "city bike" aratin (arama kutusunu xpath ile locate edin)

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("city bike" , Keys.ENTER);

        //Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement sonuc = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println(sonuc.getText());
        Thread.sleep(3500);
        //Sadece sonuc sayısını yazdırınız
       String [] sonucSayisi = sonuc.getText().split(" ");
        System.out.println("sonucSayisi = " + sonucSayisi[2]);
        Thread.sleep(3500);
        //Sonra karşınıza çıkan ilk sonucun metnine tıklayın.
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        Thread.sleep(10000);
        //sayfayi kapatınız
        driver.close();


    }
}
