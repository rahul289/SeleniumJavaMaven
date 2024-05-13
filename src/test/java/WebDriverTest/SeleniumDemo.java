package WebDriverTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Project\\SeliniumFiles\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); //launch chrome

//        System.setProperty("webdriver.gecko.driver", "D:\\Project\\SeliniumFiles\\geckodriver-v0.34.0-win32\\geckodriver.exe");
//        FirefoxDriver driver = new FirefoxDriver(); //launch chrome
        driver.get("https://www.google.com");	//enter url
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


        System.out.println(driver.getCurrentUrl());

        //System.out.println(driver.getPageSource());
        System.out.print("Code is reaching here");

        driver.quit(); //quit the browser

    }
}
