import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in); // scanner for user input for the program
        LinkedList<Product> list = new LinkedList<>(); // linked list to store and manage products


        while(true) // keep the program running until the user chooses to quit (choice 7)
        {
            printMenu();
            int choice = scanner.nextInt(); // user will input an integer
            switch (choice)
            {
                case 1: // empty the list
                    if (list.isEmpty())
                    {
                        System.out.println("List is already empty\n");
                    }
                    else
                    {
                        list.makeEmpty();
                        System.out.println("List is now empty!\n");
                    }
                    break;
                case 2: // find a product
                    System.out.print("Enter the ID: ");
                    int id = scanner.nextInt();
                    Product searchedProduct = list.findID(id);
                    if (searchedProduct!=null) // if product is found
                    {
                        System.out.println();
                        searchedProduct.printID();
                        System.out.println();
                    }
                    else // if product was not found
                    {
                        System.out.println("Product was not found.");
                        System.out.println();
                    }
                    break;
                case 3: // create and insert a product
                    String name, supplier;
                    int prodID;
                    // prompt the user to enter product details
                    System.out.println("Enter the product ID (Integer Value): ");
                    prodID = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left in the buffer

                    System.out.println("Enter the product name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter the supplier name: ");
                    supplier = scanner.nextLine();

                    Product newProduct = new Product(prodID,name,supplier); // create a product based on user input
                    if (list.insertAtFront(newProduct))
                    {
                        System.out.println("Product was successfully added!\n");
                    }
                    else // if insertion fails
                    {
                        System.out.println("Product couldn't be added, most likely because a product with the same ID already exists.\n");
                    }
                    break;
                case 4: // delete a product from the front
                    Product prod = list.deleteFromFront(); // method call
                    if (prod!=null) // if product exists
                    {
                        System.out.println("The product below was successfully deleted.\n");
                        prod.printID();
                        System.out.println();
                    }
                    else // if there are no products
                    {
                        System.out.println("There are no products to delete.\n");
                    }
                    break;
                case 5: // delete an existing product by ID search
                    System.out.print("Enter the product ID: "); // prompt user to enter the ID to search
                    int productID = scanner.nextInt();
                    Product deletedProduct = list.delete(productID); // method call with ID as argument
                    if (deletedProduct!=null) // if the product with the target ID exists
                    {
                        System.out.println("Product deleted successfully\n");
                        deletedProduct.printID();
                        System.out.println();
                    }
                    else // if product was not found
                    {
                        System.out.println("ID not found, couldn't execute deletion.\n");
                    }

                    break;
                case 6: // print all the existing created products
                    if (list.isEmpty())
                    {
                        System.out.println("There are no records, it is empty.\n");
                    }
                    else
                    {
                        System.out.println("All of the records:\n");
                        list.printAllRecords();
                    }

                    break;
                case 7: // quit the program
                    System.out.println("\nThank you, have a nice day!");
                    System.exit(0);
                default: // if user inputs a choice that's not on the menu
                    System.out.println("Invalid choice, Please retry.\n");

            }

        }
    }

    public static void printMenu() // method to display the menu
    {
        System.out.println("Menu Options:");
        System.out.println("1. Make Empty");
        System.out.println("2. Find ID");
        System.out.println("3. Insert At Front");
        System.out.println("4. Delete From Front");
        System.out.println("5. Delete ID");
        System.out.println("6. Print All Records");
        System.out.println("7. Done\n");
        System.out.print("Your choice: ");
    }
}