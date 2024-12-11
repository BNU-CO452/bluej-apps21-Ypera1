import java.util.ArrayList;
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
    
    private Product product;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();

        stock = new ProductList();
        //StockDemo demo = new StockDeo(stock);
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
            for (Product product : stock.stock) {
                System.out.println(product);
            }
        }
        else if(choice.startsWith("add "))
        {
            choice = choice.substring(4);
            String[] splited = choice.split("\\s+");
            if (stock.findProduct(Integer.parseInt(splited[0])) != null) {
                System.out.println();
                System.out.println("    "+splited[0]+" is already present in the system");
                System.out.println();
            }
            else if ( Character.isDigit(choice.charAt(0)) ) {
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
            choice = choice.substring(7);
            if (stock.findProduct(Integer.parseInt(choice)) == product) {
                stock.remove(Integer.parseInt(choice));
            }
            else {
                System.out.println();
                System.out.println("    "+choice+" is not a valid product");
                System.out.println();
            }
        }
        else if(choice.startsWith("buy "))
        {
            choice = choice.substring(4);
            String[] splited = choice.split("\\s+");
            if ( Character.isDigit(choice.charAt(0)) ) {
                stock.buyProduct(Integer.parseInt(splited[0]),Integer.parseInt(splited[1]));
            }
        }
        else if(choice.startsWith("sell "))
        {
            choice = choice.substring(5);
            String[] splited = choice.split("\\s+");
            if ( Character.isDigit(choice.charAt(0)) ) {
                stock.sellProduct(Integer.parseInt(splited[0]),Integer.parseInt(splited[1]));
            }
        }
        else if(choice.startsWith("search "))
        {
            choice = choice.substring(7);
            stock.listProductsbyPhrase(choice);
        }
        else if(choice.startsWith("low stock "))
        {
            choice = choice.substring(10);
            if(Character.isDigit(choice.charAt(0)))
            {
                stock.listProductsbyLackofStock(Integer.parseInt(choice));
            }
            else
            {
                System.out.println();
                System.out.println("    "+choice+" is not a valid number");
                System.out.println();
            }
        }
        else if(choice.startsWith("restock "))
        {
            choice = choice.substring(8);
            if(Character.isDigit(choice.charAt(0)))
            {
                stock.restockProducts(Integer.parseInt(choice));
            }
            else
            {
                System.out.println();
                System.out.println("    "+choice+" is not a valid number");
                System.out.println();
            }
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
        System.out.println("    Buy:        Buys the specified quantity of products, specify ID then product quantity");
        System.out.println("    Sell:       Sells the specified quantity of products, specify ID then product quantity");
        System.out.println("    Print:      Print all products");
        System.out.println("    Search:     Finds products with the phrase inputted");
        System.out.println("    Low Stock:  Specify a number and all products with stock below that will be printed");
        System.out.println("    Restock:    Specify a number and all products with stock below that will be have their stock set to that level");
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
        System.out.println("      by Connor Martin");
        System.out.println("********************************");
    }
}