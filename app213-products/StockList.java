import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 *
 * @author Connor Martin
 * @version 08/11/2021
 */
public class StockList {
    // A list of the products.
    public ArrayList<Product> stock;
    // Stores user name for individual stock list
    private String name;

    /**
     * Initialise the stock manager.
     */
    public StockList(String name) {
        stock = new ArrayList<Product>();
        this.name = name;
    }

    /**
     * Add a product to the list.
     *
     * @param item The product item to be added.
     */
    public void add(Product item) {
        stock.add(item);
    }
    public void remove(int productID) {
        Product product = findProduct(productID);
        if(product != null) {
            stock.remove(product);
        }
    }

    /**
     * Buy a quantity of a particular product.
     * Increase the quantity of the product by the given amount.
     *
     * @param id     The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void buyProduct(int productID, int amount) {
        if(findProduct(productID) != null) {
            findProduct(productID).increaseQuantity(amount);
        }
    }
    /**
     * Sell a quantity of a particular product.
     * Decrease the quantity of the product by the given amount.
     *
     * @param id     The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void sellProduct(int productID, int amount) {
        if(findProduct(productID) != null) {
            findProduct(productID).decreaseQuantity(amount);
        }
    }

    /**
     * Find a product to match the product id,
     * if not found return null
     */
    public Product findProduct(int productID) {
        for (Product product : stock) {
            if (product.getID() == productID) {
                return product;
            }
        }
        return null;
    }
    public void listProductsbyPhrase(String phrase) {
        for (Product product : stock) {
            if(product.getName().contains(phrase)) {
                System.out.println(product.toString());
            }
        }
    }
    public void listProductsbyLackofStock(int level) {
        for (Product product : stock) {
            if(product.getQuantity() <= level) {
                System.out.println(product.toString());
            }
        }
    }

    /**
     * Sell one of the given product.
     * Show the before and after status of the product.
     *
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int productId) {
        Product product = findProduct(productId);

        if (product != null) {
            if (numberInStock(productId) > 0) {
                product.decreaseQuantity(1);
                // printout message
                System.out.println(product.getName() + "'s stock reduced by 1");
            } else {
                // printout message
                System.out.println(product.getName() + " already sold out");
            }
        } else {
            // printout message
            System.out.println(productId + " Not Found");
        }
    }


    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     *
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int productID) {
        Product product = findProduct(productID);
        return product.getQuantity();
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     *
     * @param id The ID of the product to look for.
     */
    public void printProduct(int productID) {
        Product product = findProduct(productID);

        if (product != null) {
            System.out.println(product.toString());
        }
    }

    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void print() {
        printHeading();

        for (Product product : stock) {
            System.out.println(product);
        }

        System.out.println();
    }

    public void printHeading() {
        System.out.println();
        System.out.println(name + "'s Stock List");
        System.out.println(" ====================");
        System.out.println();
    }
}