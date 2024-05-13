package WebDriverTest;

public class processString {
    public static void main(String args[])throws Exception
    {
        String str="//https://www.pornmegaload.com/porn-models/Carmen-De-Luz/7819/?nats=MTAwNC45Ljk5LjIyOS42ODMuMC4wLjAuMA";
        if(str.contains("//https://www.pornmegaload.com/porn-models/")  && str.contains("nats=MTAwNC45Ljk5LjIyOS42ODMuMC4wLjAuMA"))
        {
            String str1=str.replaceFirst("//https://www.pornmegaload.com/porn-models/","");
            str1=str1.replaceFirst("/?nats=MTAwNC45Ljk5LjIyOS42ODMuMC4wLjAuMA","");
            System.out.println(str1);
            String str2[]=str1.split("/");
            System.out.println(str2[0]);
        }
    }
}
