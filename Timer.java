import java.io.*;
/**
 * Timer used by recorder
 * @author David Shapiro
 * @version 1.0
 */
public class Timer implements Runnable
{
	public void run()
	{
		try
		{
		 Process proc = Runtime.getRuntime().exec("python3 timer.py");
		}
		catch (Exception e){System.out.println("ERROR WITH TIMER... Sorry");}
	}
}
