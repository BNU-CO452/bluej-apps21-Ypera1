
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Connor Martin
 * @version 0.2
 */
public class StockApp
{
    private InputReader reader;
    
    private ProductList stock;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        stock = new ProductList();
        //StockDemo demo = new StockDemo(stock);
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = reader.getString("Please enter your choice > ");
            
            finished = executeChoice(choice.toLowerCase());
        }
    }
    
    private boolean executeChoice(String choice)
    {
        if(choice.equals("quit"))
        {
            return true;
        }
        else if(choice.equals("print"))
        {
            //stock.print();
        }
        else if(choice.startsWith("add "))
        {
            choice = choice.substring(4);
            if ( Character.isDigit(choice.charAt(0)) ) {
                String[] splited = choice.split("\\s+");
                product = new Product(Integer.parseInt(splited[0]),splited[1]);
                stock.add(product);
            }
            else
            {
                System.out.println();
                System.out.println("    "+splited[0]+" is not a valid number");
                System.out.println();
            }
        }
        else if(choice.startsWith("remove "))
        {
            //stock.print();
        }
        else
        {
            System.out.println();
            System.out.println("    "+choice+" is not a valid command");
            System.out.println();
        }
        return false;
    }
   
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product, enter the desired ID (a number) then the name of the Product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Print:      Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("      by Student Name");
        System.out.println("********************************");
    }
}