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
import java.time.Duration;
import java.util.List;

public class ChatGptScalping {



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
            options.addArguments("headless");
            WebDriver driver = new ChromeDriver(options); //launch chrome
            driver.get("https://chatgpt.com");	//enter url
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            String title = driver.getTitle(); //get title
            Thread.sleep(10000);
            System.out.println(title);

//            WebElement element = driver.findElement(By.xpath("//*[text()=\"New chat\"]"));
//
//            // Perform the click action on the element
//            element.click();
            WebElement element1 = driver.findElement(By.xpath("//textarea[@id=\"prompt-textarea\"]"));

            WebElement sendButton=driver.findElement(By.xpath("//button[@data-testid=\"send-button\"]"));



            //System.out.println(driver.getPageSource());
            System.out.print("Code is reaching here");


            String dir = System.getProperty("user.dir");
            System.out.println("Project location is "+dir);
            // D:\Project\SeleniumJavaMaven\src\test\FilesUsed\InputFile.txt

            //Read from file
            File file = new File(dir+
                    "\\src\\test\\FilesUsed\\InputFile.txt");

            BufferedWriter f_writer
                    = new BufferedWriter(new FileWriter(dir+
                    "\\src\\test\\FilesUsed\\OutputFile.txt"));

            // Note:  Double backquote is to avoid compiler
            // interpret words
            // like \test as \t (ie. as a escape sequence)

            // Creating an object of BufferedReader class
            BufferedReader br
                    = new BufferedReader(new FileReader(file));

            // Declaring a string variable
            String st;
            // Condition holds true till
            // there is character in a string
            while ((st = br.readLine()) != null) {

                // Print the string
                System.out.println(st);
                // Step 2: Write text(content) to file
                f_writer.write(st+"\n");
                element1.click();
                element1.sendKeys(st);
                sendButton.click();
                Thread.sleep(10000);




                List<WebElement> elements = driver.findElements(By.xpath("(//*[name()='path'][@fill='currentColor' and @d='M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1zM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1z'])"));
                System.out.println("Number of elements:" +elements.size());

                //for(int i=0; i<elements.size(); i++) //Objective is to do last copy
                {
                    elements.get(elements.size()-1).click();
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    Transferable contents = clipboard.getContents(null);
                    String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
                    if(x.length()>0) {
                        System.out.println("the result is " + x);
                        f_writer.write(x+"\n");
                    }
                }



            }
            // successful execution of the program
            System.out.print(
                    "File is created successfully with the content.");

            // Step 5: Close the BufferedWriter object
            f_writer.close();
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
}
