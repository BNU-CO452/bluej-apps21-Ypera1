import java.util.Random;
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockList stocklist;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stocklist)
    {
        this.stocklist = stocklist;
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        stocklist.add(new Product(101, "Samsung Galaxy S20"));
        stocklist.add(new Product(102, "Apple iPhone 12"));
        stocklist.add(new Product(103, "Google Pixel 4A"));
        stocklist.add(new Product(104, "Product 104"));
        stocklist.add(new Product(105, "Product 105"));
        stocklist.add(new Product(106, "Product 106"));
        stocklist.add(new Product(107, "Product 107"));
        stocklist.add(new Product(108, "Product 108"));
        stocklist.add(new Product(109, "Product 109"));
        stocklist.add(new Product(110, "Product 110"));
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        stocklist.printHeading();
        stocklist.print();

        buyProducts();
        stocklist.print();

        sellProducts();
        stocklist.print();
    }
    
    private void buyProducts()
    {
        //generates a random number object
        Random rand = new Random();
        for(Product product : stocklist.stock) {
            int id =  product.getID();
            stocklist.buyProduct(id, (rand.nextInt(9 - 1) + 1));
        }
    }

    private void sellProducts()
    {
        //generates a random number object
        Random rand = new Random();
        for(Product product : stocklist.stock) {
            int id =  product.getID();
            stocklist.sellProduct(id,(rand.nextInt(9 - 1) + 1));
        }
    }    
}