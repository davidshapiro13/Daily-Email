import java.util.ArrayList;
public class SpecialDay
{
	String date;
	String subject;
	String greeting;
	String message;
	ArrayList<String> attachments;
	public SpecialDay(String date, String subject, String greeting, String message, ArrayList<String> attachments)
	{
		this.date = date;
		this.subject = subject;
		this.greeting = greeting;
		this.message = message;
		this.attachments = attachments;
	}

	public String getDate()
	{
		return date;
	}

	public String getSubject()
	{
		return subject;
	}

	public String getGreeting()
	{
		return greeting;
	}

	public String getMessage()
	{
		return message;
	}

	public ArrayList<String> getAttachments()
	{
		return attachments;
	}
}
