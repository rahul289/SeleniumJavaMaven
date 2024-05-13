package WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;

public class SaveListToFile {
    public static HashSet<String> model;
    public static void main(String args[])throws Exception
    {
        HashSet<String> set=new HashSet<>();
        model=new HashSet<>();
        for(int i=1;i<=21;i++)
        {
            processPages(" https://www.pornmegaload.com/porn-models/?page="+i+"&nats=MTAwNC45Ljk5LjIyOS42ODMuMC4wLjAuMA",set);
        }
        System.out.println("Set size is "+set.size());
        for(String str2:set)
        {
            processName(str2);
        }
        System.out.println("Model size is "+model.size());
        dumpToFile();
    }

    public static void dumpToFile()
    {
        try{
            String dir = System.getProperty("user.dir");


            BufferedWriter f_writer
                    = new BufferedWriter(new FileWriter(dir+
                    "\\src\\test\\FilesUsed\\Models.txt"));

            // Note:  Double backquote is to avoid compiler
            // interpret words
            // like \test as \t (ie. as a escape sequence)


            // Declaring a string variable
            String st;
            // Condition holds true till
            // there is character in a string
            for(String st1:model) {

               // System.out.println(st1);
                // Step 2: Write text(content) to file
                if(st1.contains("?") || st1.equals("browse"))
                    continue;
                f_writer.write(st1+"\n");
            }
            System.out.print(
                    "File is created successfully with the content.");

            f_writer.close();
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }

    public static void processName(String str)
    {

        if(str.contains("https://www.pornmegaload.com/porn-models/")  && str.contains("nats=MTAwNC45Ljk5LjIyOS42ODMuMC4wLjAuMA"))
        {
            String str1=str.replaceFirst("https://www.pornmegaload.com/porn-models/","");
            str1=str1.replaceFirst("/?nats=MTAwNC45Ljk5LjIyOS42ODMuMC4wLjAuMA","");
            System.out.println(str1);
            String str2[]=str1.split("/");
            System.out.println("String added in model"+str2[0]);
            model.add(str2[0]);
        }
    }
    public static void processPages(String url,HashSet<String> set) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Project\\SeliniumFiles\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        // Disable CORS
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--allow-cross-origin-auth-prompt");


        // Define headless argument
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options); //launch chrome
        //WebDriver driver = new ChromeDriver(); //launch chrome

//        System.setProperty("webdriver.gecko.driver", "D:\\Project\\SeliniumFiles\\geckodriver-v0.34.0-win32\\geckodriver.exe");
//        FirefoxDriver driver = new FirefoxDriver(); //launch chrome
        //driver.get("https://www.udemy.com/course/interview-sdet-java/?couponCode=LETSLEARNNOWPP");	//enter url
        //https://www.pornmegaload.com/porn-models/browse/A/?page=4&nats=MTAwNC45Ljk5LjIyOS42ODMuMC4wLjAuMA
        // https://www.pornmegaload.com/porn-models/?page=13&nats=MTAwNC45Ljk5LjIyOS42ODMuMC4wLjAuMA
        // https://www.pornmegaload.com/porn-models/?page=21&nats=MTAwNC45Ljk5LjIyOS42ODMuMC4wLjAuMA
        // https://www.pornmegaload.com/porn-models/?page=5&nats=MTAwNC45Ljk5LjIyOS42ODMuMC4wLjAuMA


        driver.get(url);
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
                set.add(href);
                System.out.println(href + " - " + responseCode);
                // if()
                // Disconnect the connection
                connection.disconnect();
            } catch (Exception e) {
                // Print error if unable to establish connection
                System.out.println(href + " - " + "Error: " + e.getMessage());
            }
        }

        //https://www.pornmegaload.com/porn-models/Carmen-De-Luz/7819/?nats=MTAwNC45Ljk5LjIyOS42ODMuMC4wLjAuMA
        driver.quit(); //quit the browser

    }
}
