import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * Sends emails to people
 * @author Daivd Shapiro
 * @version 1.0
 */
public class Sender implements General
{
    ArrayList<Person> people;
    ArrayList<String> dailyMessages;
    ArrayList<Holiday> holidays;
    ArrayList<String> greetings;
    ArrayList<SpecialDay> specialDays;

    Utility u = new Utility();
    String todayDate;
	
    String run = "python3";
    String fileName = "emailSender.py";
    String subject = SUBJECT;
    String photo;
    String audio;

    /**
     * Sender constructor
     */
    public Sender()
    {
        todayDate = u.getDate();
        System.out.println("Today is " + todayDate);

        //Loads the info
        FileOpener fo = new FileOpener();
        people = fo.loadPeople();
        dailyMessages = fo.loadItems(messagePath);
        greetings = fo.loadItems(greetingsPath);
        holidays = fo.loadHolidays();
	specialDays = fo.loadSpecialDays();
	photo = PHOTO_FOLDER + todayDate + photoExt;
	audio = AUDIO_FOLDER + todayDate + audioExt;

	if (isSpecialDay())
	{
		subject = getSpecialDay().getSubject();
	}
    }

    /**
     * Sends the emails
     */
    public void send()
    {
        try
        {
            for (Person p : people) //each person gets an email
            {
                String email = p.getEmail();
                String name = p.getFirstName();
                String message = getMessage(p);
                String greeting = getGreeting(p);

		ArrayList<String> emailArguments = new ArrayList<String>();

                System.out.println("Emailing test with " + p.getFirstName());

                String writing = greeting + " " + name + ", " + message + signature;
		System.out.println(run + " " + fileName + " " + writing + " " + subject + " " + email +  " " +  photo +  " " + audio);                

		emailArguments.add(run);
		emailArguments.add(fileName);
		emailArguments.add(writing);
		emailArguments.add(subject);
		emailArguments.add(email);
		emailArguments.add(photo);
		emailArguments.add(audio);
	
		if (isSpecialDay() && (getSpecialDay().getAttachments() != null))
		{
			ArrayList<String> attachments = getSpecialDay().getAttachments();
			for (String attachment : attachments)
			{
				emailArguments.add(attachment);
			}
		}

		String[] emailArgumentsArray = u.arrayListToArray(emailArguments);
		System.out.print("SENDING THIS TO PYTHON CODE ");
        	for (int x = 0; x < emailArgumentsArray.length; x++)
        		System.out.print(emailArgumentsArray[x] + " ");
		System.out.println();
	
		Process proc = Runtime.getRuntime().exec(emailArgumentsArray);
                u.sleep(180);
            }
        }
        catch (IOException e)
        {
            u.playWav(new File(emailErrorPath));
        }
    }

    /**
     * Sends a custom message in email
     * @param message to send
     */
    public void send(String customMessage)
    {
        try
        {
            for (Person p : people)
            {
                System.out.println("Emailing " + p.getFirstName());
                String email = p.getEmail();
                String name = p.getFirstName();
                String message = customMessage;
                String greeting = getGreeting(p);

                String writing = greeting + " " + name + ", " + message + signature;
             
		System.out.println("HELLLLLLLOOOOO CUTIE " + writing);
                Process proc = Runtime.getRuntime().exec(new String[] {run, fileName, 
                            writing, subject, email, photo, audio});
		System.out.println("That task is complete! " + customMessage);
                u.sleep(180);
            }
        }
        catch (IOException e)
        {
            u.playWav(new File(emailErrorPath));
        }
    }

    /**
     * Send email with custom subject and custom message
     * @param message
     * @param subject
     */
    public void send(String customMessage, String subject)
    {
		this.subject = subject;
	System.out.println("THIS IS NEW _ PLEASE HELP! IN SEND WITH 2 arguments");	
        try
        {
            for (Person p : people)
            {
                String email = p.getEmail();
                String name = p.getFirstName();
                String message = customMessage;
                String greeting = getGreeting(p);

                String writing = greeting + " " + name + ", " + message + signature;
        		
		Process proc = Runtime.getRuntime().exec(new String[] {run, fileName, 
                				            writing, subject, email, photo, audio});
                u.sleep(180);
            }
        }
        catch (IOException e)
        {
            u.playWav(new File(emailErrorPath));
        }
    }

    /**
     * Send with custom message, image and audio
     * @param message
     * @param jpg name
     * @param audio name
     */
    public void send(String customMessage, String jpgName, String wavName)
    {
		this.photo = jpgName;
		this.audio = wavName;
        try
        {
            for (Person p : people)
            {
                String email = p.getEmail();
                String name = p.getFirstName();
                String message = customMessage;
                String greeting = getGreeting(p);

                String writing = greeting + " " + name + ", " + message + signature;
                
				Process proc = Runtime.getRuntime().exec(new String[] {run, fileName, 
                            writing, subject, email, photo, audio});
                u.sleep(180);
            }
        }
        catch (IOException e)
        {
            u.playWav(new File(emailErrorPath));
        }
    }

    /**
     * Sends email with custom message, subject, jpg name, audio name
     * @param message
     * @param subject
     * @param jpgName
     * @param wavName
     */
    public void send(String customMessage, String subject, String jpgName, String wavName)
    {
		this.photo = jpgName;
		this.audio = wavName;
		this.subject = subject;
        try
        {
            for (Person p : people)
            {
                String email = p.getEmail();
                String name = p.getFirstName();
                String message = customMessage;
                String greeting = getGreeting(p);

                String writing = greeting + " " + name + ", " + message + signature;
                
				Process proc = Runtime.getRuntime().exec(new String[] {run, fileName, 
                            writing, subject, email, photo, audio});
                u.sleep(180);
            }
        }
        catch (IOException e)
        {
            u.playWav(new File(emailErrorPath));
        }
    }

    /**
     * Create message based on day
     * @param person
     * @return message
     */
    private String getMessage(Person p)
    {
        String message;

	if (isSpecialDay())
	    message = (getSpecialDay()).getMessage();
        else if (p.isBirthday(todayDate))
            message = birthdayMessage;
        else if (isHoliday())
            message = (getHoliday()).getMessage();
        else
            message = getDailyMessage();
        return message;
    }

    /**
     * Decide if it is a holiday
     * @return true if holiday; false otherwise
     */
    private boolean isHoliday()
    {
        for (Holiday h : holidays)
        {
            if ((h.getDate()).equals(todayDate))
                return true;
        }
        return false;
    }

    private boolean isSpecialDay()
    {
	for (SpecialDay day : specialDays)
	{
		System.out.println(day.getDate());
		if ((day.getDate()).equals(todayDate))
			return true;
	}
	return false;
    }

    /**
     * Gives random daily message
     * @return message
     */
    private String getDailyMessage()
    {
        int itemNum = (int)(Math.random() * dailyMessages.size()); 
        return dailyMessages.get(itemNum);
    }

    /**
     * Gives a greeting
     * @param person
     * @return greeting
     */
    private String getGreeting(Person p)
    {
        int itemNum;
        String greeting;

	if (isSpecialDay())
	{
	    greeting = (getSpecialDay()).getGreeting();
            System.out.println("GOOOOOOD KIDDDDD LOL 24 0f 5");
	}
	else if (p.isBirthday(todayDate))
            greeting = birthdayGreeting;
        else if (isHoliday())
            greeting = HOLIDAY_GREETING + " " + (getHoliday()).getName();
        else
        {
            itemNum = (int)(Math.random() * greetings.size()); 
            greeting = greetings.get(itemNum);
        }
        return greeting;
    }

    /**
     * Get holiday
     * @return holiday
     */
    private Holiday getHoliday()
    {
        for (Holiday h : holidays)
        {
	    System.out.println(h);
            if ((h.getDate()).equals(todayDate))
                return h;
        }
        return null;
    }

  private SpecialDay getSpecialDay()
  {
	for (SpecialDay day : specialDays)
	{
		if ((day.getDate()).equals(todayDate))
		{
			return day;
		}
	}
	return null;
  }

	
}
