import org.jsoup.Jsoup;
import java.util.ArrayList;
import org.jsoup.nodes.Document;
import java.io.*;
/**
 * Write a description of class WebScraper here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WebScraper implements General
{
    String websiteName; 
    Document doc;
    String[] command = {"python3", "surgeWriter.py"};
    PrintWriter writer;
    /**
     * Constructor for objects of class WebScraper
     */
    public WebScraper(String websiteName)
    {
        this.websiteName = websiteName;
    }

    public ArrayList<String> getSpecialParts()
    {
	ArrayList<String> specialParts = new ArrayList<String>();

        try
        {
            doc = Jsoup.connect(websiteName).get();
            String[] parts = doc.body().text().split(",, ");
	    System.out.println("text " + doc.body().text());            
	    boolean specialMessage = !parts[2].equals("custom message");
	    boolean messageAndSubject = !parts[1].equals("subject") && !parts[2].equals("custom message");
            boolean allCustom = messageAndSubject && !parts[3].equals("image name") && !parts[4].equals("audio name"); 

	    if (allCustom)
	    {
		specialParts.add(parts[1]);	
		specialParts.add(parts[2]);
		specialParts.add(parts[3]);
		specialParts.add(parts[4]);
	    }
	
	   else if (messageAndSubject)
	   {
		specialParts.add(parts[1]);
		specialParts.add(parts[2]);
	   }

	   else if (specialMessage)
	   {
		specialParts.add(parts[2]);
           }

	  return specialParts;
	}
        catch (Exception e)
	{
		System.out.println(e.getMessage());
		return null;
	}
      
        
    }
    public void reset()
    {
	try
        {
            writer = new PrintWriter(WEBSITE_PATH);
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head></head>");
            writer.println("<body>");
            writer.println("<h1>Daily Email,,</h1>");
            writer.println("<h2>subject,,</h2>");
            writer.println("<h3>custom message,,</h3>");
            writer.println("<h4>image name,,</h4>");
            writer.println("<h5>audio name</h5>");
            writer.println("<img src=\"genericPhoto.jpg\" alt=\"image\">");
            writer.println("</body>");
            writer.println("</html>");
            writer.close();

        }
        catch (Exception e){}
    }
}
