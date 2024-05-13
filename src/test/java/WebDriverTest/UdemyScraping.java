package WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UdemyScraping {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Project\\SeliniumFiles\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");


        WebDriver driver = new ChromeDriver(); //launch chrome

//        System.setProperty("webdriver.gecko.driver", "D:\\Project\\SeliniumFiles\\geckodriver-v0.34.0-win32\\geckodriver.exe");
//        FirefoxDriver driver = new FirefoxDriver(); //launch chrome
        driver.get("https://www.udemy.com/course/interview-sdet-java/?couponCode=LETSLEARNNOWPP");	//enter url
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String title = driver.getTitle(); //get title

        Thread.sleep(10000);
        System.out.println(title);

        //validation point:
        if(title.equals("Google")){
            System.out.println("correct title");
        }
        else{
            System.out.println("in-correct title");
        }
        WebElement element = driver.findElement(By.xpath("//span[text()='Java Theoretical Questions']"));

        // Perform the click action on the element
        element.click();

        List<WebElement> elements = driver.findElements(By.xpath("//span"));
        System.out.println("Number of elements:" +elements.size());

        for(int i=0; i<elements.size(); i++){
            String text=elements.get(i).getText();
            if(text.length()>0)
                System.out.println(elements.get(i).getAttribute("class") + "is attribute and is text " + elements.get(i).getText());
        }

        //System.out.println(driver.getPageSource());
        System.out.print("Code is reaching here");


        driver.quit(); //quit the browser

    }
}
