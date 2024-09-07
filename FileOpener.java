import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Loads the various files needed
 *
 * @author David Shapiro
 * @version 1.0
 */
public class FileOpener implements General
{
    Utility util = new Utility();
    
    /**
     * Loads people into an arraylist
     * @return array of people
     */
    public ArrayList<Person> loadPeople()
    {
        int personNumber;
        String line;
        String firstName, lastName, email, joinDate, birthday;
        Person person;

        ArrayList<Person> people = new ArrayList<Person>(); 
        String[] parts;
        try
        {
            FileReader reader = new FileReader(memberPath);
            Scanner scan = new Scanner(reader);

            scan.nextLine(); //Clears title line

            //Read every line
            while (scan.hasNext())
            {
                line = scan.nextLine();
                parts = line.split(", ");
                
                personNumber = Integer.parseInt(parts[0]);
                firstName = parts[1];
                lastName = parts[2];
                email = parts[3];
                birthday = parts[4];
                joinDate = parts[5];

                person = new Person(firstName, lastName, 
                                    email, birthday, joinDate, personNumber);
                people.add(person);
            }
            
            return people;
        }
        catch (IOException e)
        {
            util.playWav(new File(loadingErrorPath));
            System.exit(0);
            return null;
        }
    }
    
    /**
     * Loads any item from a file line by line 
     * @param path of file
     * @return array of items
     */
    public ArrayList<String> loadItems(String path)
    {
        String line;
        ArrayList<String> messages = new ArrayList<String>(); 
        try
        {
            FileReader reader = new FileReader(path);
            Scanner scan = new Scanner(reader);

            scan.nextLine(); //Clears title line

            //Read every line
            while (scan.hasNext())
            {
                line = scan.nextLine();
               
                messages.add(line);
            }
        }
        catch (IOException e)
        {
            util.playWav(new File(loadingErrorPath));
            System.exit(0);
        }
        return messages;
    }
    
    
    /**
     * Loads all holidays
     * @return array of holidays
     */
    public ArrayList<Holiday> loadHolidays()
    {
        String line, date, holidayName, message;
        Holiday holiday;
        String[] parts;
        ArrayList<Holiday> holidays = new ArrayList<Holiday>(); 
        try
        {
            FileReader reader = new FileReader(holidaysPath);
            Scanner scan = new Scanner(reader);

            scan.nextLine(); //Clears title line

            //Read every line
            while (scan.hasNext())
            {
                line = scan.nextLine();
		
                parts = line.split(",, ");
		System.out.println(parts[0] + " " + parts[1] + " " + parts[2]);
                date = parts[0];
                holidayName = parts[1];
                message = parts[2];
                
                holiday = new Holiday(date, holidayName, message);
                holidays.add(holiday);
            }
        }
        catch (IOException e)
        {
            util.playWav(new File(loadingErrorPath));
            System.exit(0);
        }
        return holidays;
    }

   public ArrayList<SpecialDay> loadSpecialDays()
   {
	String line, date, subject, greeting, message;
	ArrayList<String> attachments = new ArrayList<String>();
	ArrayList<SpecialDay> specialDays = new ArrayList<SpecialDay>();
	String[] parts;

	try
        {
            FileReader reader = new FileReader(specialDayPath);
            Scanner scan = new Scanner(reader);

            scan.nextLine(); //Clears title line

            //Read every line
            while (scan.hasNext())
            {
                line = scan.nextLine();
		attachments = new ArrayList<String>();                
                parts = line.split(",, ");
                System.out.println(parts[0] + " " + parts[1] + " " + parts[2]);
                date = parts[0];
                subject = parts[1];
                greeting = parts[2];
		message = parts[3];
		if (parts.length > 4)
		{
			for (int x = 4; x < parts.length; x++)
			{
				attachments.add(parts[x]);
			}
		}
                
                SpecialDay specialDay = new SpecialDay(date, subject, greeting, message, attachments);
                specialDays.add(specialDay);
            }
        }
        catch (IOException e)
        {
            util.playWav(new File(loadingErrorPath));
            System.exit(0);
        }
        return specialDays;
   }
}
