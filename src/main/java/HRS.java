import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HRS {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.hrs.de/";


        driver.get(baseUrl);
        driver.manage().window().maximize();
        //Handle pop up to accept all cookies
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();


        WebElement location=driver.findElement(By.xpath("//span[@class='DestinationSearchOpener_destinationFormat__hwuCN']"));
        location.click();
        Thread.sleep(2000);
        WebElement enteringlocation=driver.findElement(By.xpath("//input[@id='DestinationSearchInput']"));
        enteringlocation.sendKeys("Barcelona");
        Thread.sleep(2000);
        enteringlocation.sendKeys(Keys.ENTER);
        WebElement dateInput = driver.findElement(By.xpath("//div[@data-test='DateRangeInputField_date']"));
        dateInput.click();
        WebElement arrival = driver.findElement(By.xpath(" //div[@class='Calendar_monthsDesktop__5TRHv']/div[@id='selectedMonth']//div[.='21']"));
        arrival.click();
        WebElement departure = driver.findElement(By.xpath(" //div[@class='Calendar_monthsDesktop__5TRHv']/div[@id='selectedMonth']//div[.='28']"));
        departure.click();
        WebElement hotels=driver.findElement(By.xpath("//button[@id='SearchHotelsButton']"));
        hotels.click();

        Thread.sleep(3000);
        //There was no filter to search on availability of hotel so i have applied filter as price
        WebElement price=driver.findElement(By.xpath("//input[@id='priceInput']"));
        price.sendKeys("100");
        price.sendKeys(Keys.ENTER);

// To open the low price hotels
        WebElement hotel1=driver.findElement(By.xpath(" (//div[@class='OfferInfo_containerLarge__LGzke']//button)[1]"));
        hotel1.click();

        Thread.sleep(3000);




        driver.close();
    }

}
