package WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Flipkart {
    public static void main(String args[])throws Exception
    {
        try{

            System.setProperty("webdriver.chrome.driver", "D:\\Project\\SeliniumFiles\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
            // Create ChromeOptions instance
            ChromeOptions options = new ChromeOptions();
            // Disable CORS
            options.addArguments("--disable-web-security");
            options.addArguments("--allow-running-insecure-content");
            options.addArguments("--allow-cross-origin-auth-prompt");


            // Define headless argument
            //options.addArguments("headless");
            WebDriver driver = new ChromeDriver(options); //launch chrome
            driver.get("https://www.flipkart.com/");	//enter url
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            String title = driver.getTitle(); //get title
            Thread.sleep(10000);
            System.out.println(title);

//            WebElement element = driver.findElement(By.xpath("//*[text()=\"New chat\"]"));
//
//            // Perform the click action on the element
//            element.click();
            ////*[@id="container"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div[2]/div/div/div/div/img
            WebElement element1 = driver.findElement(By.xpath("//div[@class='_1ch8e_'][2]"));
            ////div[@class='_16rZTH']//a
            element1.click();

            //div[@class='_16rZTH']
            // if contains below
            //class= _1BJVlg

            List<WebElement> links = driver.findElements(By.xpath("//div[@class='_16rZTH']//a"));
            //or



            ///
            // Get all links on the webpage

            // Iterate through each link
            for (WebElement link : links) {
              //  String href = link.getAttribute("href");

                    // Open a connection to the URL
                    System.out.println(link.getText());


            }


        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
}


/*
* //*[@id="container"]//div[3]//div[2]//div[1]/input
//*[@id="container"]//div[3]//div[2]//input
//*[@id="container"]//div[3]//div[2]//div[1]/input
//*[@id="container"]//div[3]//div[2]//div[1]/input
//*[@id="container"]//div[3]//div[2]//div[1]/input

//*[@id="container"]//div[3]//form//input

(//input[@type='text' and @autocomplete='off'])[2] -> Working answer 1
//input[@type='text']//span[text()='Enter Email/Mobile number']

//input[contains(.,'Enter Email/Mobile number')]

//span[@class='example']/ancestor::div//input[1]
//span[contains(text(),'Enter Email/Mobile number')]/ancestor::div//input[1]

// -> //span[contains(text(),'Enter Email/Mobile number')]/ancestor::div/input

span by using ancestor on the basis of input test
// -> //span[contains(text(),'Enter Email/Mobile number')]/ancestor::div/input -? Working answer 2

//span[text()='Enter Email/Mobile number']

(//input[@type='text' and @autocomplete='off'])[2]

 */