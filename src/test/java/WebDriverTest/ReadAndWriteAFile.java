package WebDriverTest;

import java.io.*;

public class ReadAndWriteAFile {
    //create utility package and use
    //create pom and use it
    public static void main(String args[])throws Exception
    {
        try{
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
