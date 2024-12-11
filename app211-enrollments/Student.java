/**
 * The Student class contains essential information that identifies 
 * a student at BNU.  The class also contains information 
 * concerning the course the student is currently enrolled on
 * 
 * @author Michael Kölling and David Barnes
 * @modified by Derek Peacock and Nicholas Day
 * @version 2021:08:15
 */
public class Student
{
    // A unique 8 digit BNU identifier
    private int id;
    // the student's full name
    private String name;
    // The course the student is enrolled on
    private Course course;
    
    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    /**
     * Prints the full name of this student in the terminal
     */
    public void getName()
    {
        System.out.println("Name of Student is: "+ name);
    }

     /**
     * Prints the student ID of this student in the terminal
     */
    public void getID()
    {
        System.out.println("Student's ID is: "+ id);
    }
    /** 
     * Enroles student on specified availible courses)
     */
    public void enrol(Course course)
    {
        this.course = course;
        System.out.println("Enroled on Course: "+ course.title);
    }
    
    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print()
    {
        System.out.println(" Student ID: " + id + " Name: " + name);
    }
    
    /**
     * Print the details of the course, the list
     * of students enrolled and the module
     * Inherited from Course
     */
    public void printCourse()
    {
        if(course != null) { course.print(); } 
        else { System.out.println("No Course Found");   
        }
    }
}

