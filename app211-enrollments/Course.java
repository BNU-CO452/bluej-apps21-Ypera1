import java.util.*;

/**
 * This class contains information about an undergraduate course
 * at BNU together with a list of student who are enrolled
 *
 * @author Derek Peacock
 * @modified Connor Martin
 * @version 1.01 20/10/2021
 */
public class Course
{
    // A unique identifier e.g. BT1CTG1
    public String code;
    // The full title including qualification and subject
    public String title;
    //Assigned Module of Course
    private Module module;
    
    /**
     * Create a Course with a maximum number of enrolments. 
     * All other details are set to unkown values.
     */
    public Course(String code, String title)
    {
        this.code = code;
        this.title = title;
        this.module = null;
    }

    
    /**
     * Print the details of the course, the list
     * of students enrolled and the module
     */
    public void print()
    {
        printHeading();
        
        System.out.println(" Course Code: " + code + ": " + title);
        if(module != null) {
            System.out.println(" Module: "+ module.title);
            System.out.println(" Code: "+ module.code);
            System.out.println(" Credit: "+ module.credit);
        }
        System.out.println();
    }
    
    /**
     * Print out the details of the course to the terminal.
     */
    private void printHeading()
    {
        System.out.println(" --------------------------------");
        System.out.println("   App211: Course Details");
        System.out.println(" --------------------------------");
        System.out.println();
    }
    
    /**
     * Sets module of course
     */
    public void setModule(Module module) {
        this.module = module;
        System.out.println(title + " module set to " + module.title);
    }
}
