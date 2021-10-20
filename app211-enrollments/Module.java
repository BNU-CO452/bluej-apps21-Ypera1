
/**
 * Write a description of class Module here.
 *
 * @author (Connor Martin)
 * @version (1.0)
 */
public class Module
{
    // A unique identifier e.g. C0452
    public String code;
    // The full title of the Module e.g. "Web Development"
    public String title;
    // The assigned credit value of the module, defaults to "Not Set"
    public String credit = "Not Set";
    
    /**
     * Create a Course with a maximum number of enrolments. 
     * All other details are set to unkown values.
     */
    public Module(String code, String title)
    {
        this.code = code;
        this.title = title;
    }

    public void getCode() {System.out.println("Module Code is: " + code);}
    public void getTitle() {System.out.println("Module Title is: " + title);}
    public void getCredit() {System.out.println("Module Credit is: " +credit);}

    public void getDetails() {
        getCode();
        getTitle();
        getCredit();
    };
    
    public void setCredit(String credit) {
        this.credit = credit;
        System.out.println("Credit set to " + credit);
    }
    
}
