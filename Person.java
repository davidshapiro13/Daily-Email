 

import java.util.Date;

/**
 * Description of a person
 * @author David Shapiro
 * @version 1.0
 */
public class Person {

    private String firstName;
    private String lastName;
    private String email;
    private String joinDate;
    private String birthday;
    private int personNumber;
    
    /**
     * Person constructor
     * @param first name
     * @param last name
     * @param email
     * @param joinDate
     * @param birthday
     * @param order number
     */
    public Person(String firstName, String lastName, String email, 
                  String birthday, String joinDate, int number)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.joinDate = joinDate;
        this.birthday = birthday;
        this.personNumber = number;
    }

    /**
     * Get first name
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get last name
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Get email
     * @return email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Checks if today is their birthday
     * @return ture if birthday; false otherwise
     */
    public boolean isBirthday(String todaysDate)
    {
	System.out.println("Today is " + todaysDate + " birthday is " + birthday + " substring is " + todaysDate.substring(5));
        return birthday.equals(todaysDate.substring(5));
    }


    
}
