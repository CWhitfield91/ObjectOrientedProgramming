package hardwarestore;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to manage transactions database
 */
public class Transactions implements Serializable{

    private String employeeName;
    private String customerName;
    private String itemName;
    private int quantitySold;

    private ArrayList<Transactions> transactions = new ArrayList<Transactions>();

    /**
     * default Transactions constructor
     */
    public Transactions() {

    }

    /**
     * 4 parameter constructor used to create object to put in ArrayList
     * @param employeeName the employee first name the completed the transaction
     * @param customerName customer first name that completed the transaction
     * @param itemName name of item sold
     * @param quantitySold quantity of item sold
     */
    public Transactions(String employeeName, String customerName, String itemName,
                        int quantitySold) {
        this.employeeName = employeeName;
        this.customerName = customerName;
        this.itemName = itemName;
        this.quantitySold = quantitySold;
    }

    /**
     * gets employeeName
     * @return employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * gets customerName
     * @return customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * gets itemName
     * @return itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * gets quantitySold
     * @return quantitySold
     */
    public int getQuantitySold() {
        return quantitySold;
    }

    /**
     * Completes a transaction. If an employee or customer do not exist in database yet, prompts
     * the user to first create them and place them in database. If item does not exist in database,
     * prompts the user to first add the item from the main menu
     * @param userDatabase userDatabase object
     * @param inventory inventory object
     */
    public void completeTransaction(UserDatabase userDatabase, Inventory inventory) {
        Scanner scanEmployeeName = new Scanner(System.in);
        Scanner scanCustomerName = new Scanner(System.in);
        Scanner scanItemName = new Scanner(System.in);
        Scanner scanQuantitySold = new Scanner(System.in);

        System.out.print("Please enter employee first name: ");
        String employeeName = scanEmployeeName.nextLine();
        if (!userDatabase.containsEmployee(employeeName)) {
            System.out.println("Employee does not exist in database, please add employee now.");
            userDatabase.addEmployee();
        }

        System.out.print("Please enter customer first name: ");
        String customerName = scanCustomerName.nextLine();
        if (!userDatabase.containsCustomer(customerName)) {
            System.out.println("Customer does not exist in database, please add customer now.");
            userDatabase.addCustomer();
        }

        System.out.print("Please enter item name to be sold: ");
        String itemName = scanItemName.nextLine();
        if (!inventory.containsItem(itemName)) {
            System.out.println("Item not found in inventory, please add item from main menu.");
            return;
        }

        System.out.print("Please enter quantity of item sold: ");
        int quantitySold = scanQuantitySold.nextInt();
        inventory.subtractItemQuantity(itemName, quantitySold);

        Transactions newTransaction = new Transactions(employeeName, customerName, itemName,
                quantitySold);

        transactions.add(newTransaction);
    }

    /**
     * prints the transactions ArrayList
     */
    public void printTransactionHistory() {
        System.out.format(String.format("%s %15s %15s %15s",
                "Employee Name", "Customer Name", "Item Name", "Quantity Sold"));
        System.out.println();

        for (Transactions transaction : transactions) {
            System.out.format(String.format("%1s %16s %19s %10d",
                    transaction.getEmployeeName(),
                    transaction.getCustomerName(),
                    transaction.getItemName(),
                    transaction.getQuantitySold()));
            System.out.println();
        }
    }

    /**
     * writes the transactions ArrayList to a .dat file. Creates the .dat file if one is not already present
     */
    public void writeToFile() {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("transactionsDatabase.dat"));
            out.writeObject(transactions);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * reads from the .dat file and populates the transactions ArrayList
     */
    public void inputFromFile() {

        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("transactionsDatabase.dat"));
            transactions = (ArrayList<Transactions>) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
