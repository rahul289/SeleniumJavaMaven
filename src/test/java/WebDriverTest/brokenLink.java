package WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class brokenLink {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Project\\SeliniumFiles\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");


        WebDriver driver = new ChromeDriver(); //launch chrome

//        System.setProperty("webdriver.gecko.driver", "D:\\Project\\SeliniumFiles\\geckodriver-v0.34.0-win32\\geckodriver.exe");
//        FirefoxDriver driver = new FirefoxDriver(); //launch chrome
        //driver.get("https://www.udemy.com/course/interview-sdet-java/?couponCode=LETSLEARNNOWPP");	//enter url
        //https://www.pornmegaload.com/porn-models/browse/A/?page=4&nats=MTAwNC45Ljk5LjIyOS42ODMuMC4wLjAuMA
        // https://www.pornmegaload.com/porn-models/?page=13&nats=MTAwNC45Ljk5LjIyOS42ODMuMC4wLjAuMA
        // https://www.pornmegaload.com/porn-models/?page=21&nats=MTAwNC45Ljk5LjIyOS42ODMuMC4wLjAuMA
        // https://www.pornmegaload.com/porn-models/?page=5&nats=MTAwNC45Ljk5LjIyOS42ODMuMC4wLjAuMA


        driver.get("https://www.pornmegaload.com/porn-models/?page=1&nats=MTAwNC45Ljk5LjIyOS42ODMuMC4wLjAuMA");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String title = driver.getTitle(); //get title

        Thread.sleep(10000);
        System.out.println(title);

        //validation point:
        List<WebElement> links = driver.findElements(By.tagName("a"));
        //or
        List<WebElement> links1 = driver.findElements(By.xpath("//a"));



        ///
        // Get all links on the webpage

        // Iterate through each link
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            try {
                // Open a connection to the URL
                HttpURLConnection connection = (HttpURLConnection) new URL(href).openConnection();
                // Get response code
                connection.setRequestMethod("HEAD");
                connection.connect();
                int responseCode = connection.getResponseCode();
                // Print URL and response code

                System.out.println(href + " - " + responseCode);
               // if()
                // Disconnect the connection
                connection.disconnect();
            } catch (Exception e) {
                // Print error if unable to establish connection
                System.out.println(href + " - " + "Error: " + e.getMessage());
            }
        }


        driver.quit(); //quit the browser

    }
}
