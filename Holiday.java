 
/**
 * Description for holiday
 * @author David Shapiro
 * @version 1.0
 */
public class Holiday {
    private String date;
    private String name;
    private String message;
    
    /**
     * Constructor for holiday
     * @param date of holiday
     * @param name of holiday
     * @param message
     */
    public Holiday(String date, String holidayName, String message)
    {
        this.date = date;
        this.name = holidayName;
        this.message = message;
    }
    
    /**
     * get date of holiday
     * @return date
     */
    public String getDate()
    {
        return date;
    }
    
    /**
     * get holiday message
     * @return message
     */
    public String getMessage()
    {
        return message;
    }
    
    /**
     * get name of holiday
     * @return holiday name
     */
    public String getName()
    {
        return name;
    }

   /**
   * to string of holiday
   * @return string of holiday
   */
   public String toString()
   {
    return date + " " + name + " " + message;
   }

}

 
