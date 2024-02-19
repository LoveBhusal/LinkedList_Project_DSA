import java.sql.SQLOutput;

public class Product implements IDedObject
{
    // private member variables associated with the product
    private final int productID;
    private final String productName;
    private final String supplierName;

    public Product(int productID, String productName, String supplierName) // constructor
    {
        this.productID = productID;
        this.productName = productName;
        this.supplierName = supplierName;
    }

    @Override
    public int getID() // overriding the abstract method from IDedObject interface
    {
        return productID; // getter
    }

    @Override
    public void printID() // overriding the abstract method from IDedObject interface
    {
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Supplier Name: " + supplierName);
        System.out.println("\n--------------------------");

    }
}
