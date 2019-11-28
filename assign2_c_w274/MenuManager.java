package hardwarestore;

import java.util.Scanner;

/**
 * Prints the menu and manages user input
 */
public class MenuManager {

    public void printMenu(Inventory inventory, UserDatabase userDatabase, Transactions transactions){

        int choice;

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1: Show all existing items in stock and their existing quantities.");
            System.out.println("2. Add a new item (or quantity) to the database.");
            System.out.println("3. Delete an item from a database.");
            System.out.println("4. Search for an item given its name.");
            System.out.println("5. Show a list of users in the database.");
            System.out.println("6. Add new user to the database.");
            System.out.println("7. Update user info (given their ID).");
            System.out.println("8. Complete a sale transaction.");
            System.out.println("9. Show completed sales transactions.");
            System.out.println("10. Exit program.");
            System.out.print("Please select a choice: ");
            choice = scanner.nextInt();

            switch (choice){

                case (1):
                    inventory.printSmallHardwares();
                    System.out.println();

                    inventory.printAppliances();
                    System.out.println();
                    break;

                case (2):
                    System.out.print("Would you like to add a NEW ITEM or update QUANTITY? ");
                    Scanner update = new Scanner(System.in);
                    String updateInventory = update.nextLine();

                    while (!(updateInventory.toLowerCase().equals("new item") ||
                            updateInventory.toLowerCase().equals("quantity"))) {
                        System.out.print("Invalid input. Please enter NEW ITEM or QUANTITY: ");
                        updateInventory = update.nextLine();
                    }

                    if (updateInventory.toLowerCase().equals("new item")) {
                        Scanner addToInventory = new Scanner(System.in);
                        System.out.print("Add SMALL HARDWARE or APPLIANCE? ");
                        String addItem = addToInventory.nextLine();

                        while (!(addItem.toLowerCase().equals("small hardware") ||
                                addItem.toLowerCase().equals("appliance"))) {
                            System.out.print("Invalid input. Please enter SMALL HARDWARE or APPLIANCE: ");
                            addItem = addToInventory.nextLine();
                        }

                        if (addItem.toLowerCase().equals("small hardware")){
                            inventory.addSmallHardware();
                        }

                        if (addItem.toLowerCase().equals("appliance")){
                            inventory.addAppliance();
                        }
                    }
                    else {
                        System.out.print("Do you wish to update quantity of SMALL HARDWARE or APPLIANCE? ");
                        Scanner scanItem = new Scanner(System.in);
                        String itemType = scanItem.nextLine();

                        while (!(itemType.toLowerCase().equals("small hardware") ||
                                itemType.toLowerCase().equals("appliance"))) {
                            System.out.print("Invalid input. Please enter SMALL HARDWARE or APPLIANCE: ");
                            itemType = scanItem.nextLine();
                        }
                        if (itemType.toLowerCase().equals("small hardware")) {
                            Scanner scanItemName = new Scanner(System.in);
                            Scanner scanItemQuantity = new Scanner(System.in);

                            System.out.print("Please enter item name: ");
                            String name = scanItemName.nextLine();

                            System.out.print("Please enter new quantity: ");
                            int quantity = scanItemQuantity.nextInt();

                            inventory.updateSmallHardwareQuantity(name, quantity);
                        }

                        if (itemType.toLowerCase().equals("appliance")) {
                            Scanner scanItemName = new Scanner(System.in);
                            Scanner scanItemQuantity = new Scanner(System.in);

                            System.out.print("Please enter item name: ");
                            String name = scanItemName.nextLine();

                            System.out.print("Please enter new quantity: ");
                            int quantity = scanItemQuantity.nextInt();

                            inventory.updateApplianceQuantity(name, quantity);
                        }
                    }

                    break;

                case (3):
                    System.out.print("Delete SMALL HARDWARE or APPLIANCE? ");
                    Scanner scanItemType = new Scanner(System.in);
                    String itemType = scanItemType.nextLine();

                    while (!(itemType.toLowerCase().equals("small hardware") ||
                            itemType.toLowerCase().equals("appliance"))) {
                        System.out.print("Invalid input. Please enter SMALL HARDWARE or APPLIANCE: ");
                        itemType = scanItemType.nextLine();
                    }

                    if (itemType.toLowerCase().equals("small hardware")) {
                        inventory.removeSmallHardware();
                    }

                    if (itemType.toLowerCase().equals("appliance")) {
                        inventory.removeAppliance();
                    }
                    break;

                case (4):
                    System.out.print("Do you wish to look up SMALL HARDWARE or APPLIANCE? ");
                    Scanner scanItem = new Scanner(System.in);
                    String item = scanItem.nextLine();

                    while (!(item.toLowerCase().equals("small hardware") ||
                            item.toLowerCase().equals("appliance"))) {
                        System.out.print("Invalid input. Please enter SMALL HARDWARE or APPLIANCE: ");
                        item = scanItem.nextLine();
                    }

                    if (item.toLowerCase().equals("small hardware")) {
                        inventory.lookUpSmallHardware();
                    }

                    if (item.toLowerCase().equals("appliance")) {
                        inventory.lookUpAppliance();
                    }
                    break;

                case (5):
                    userDatabase.printEmployees();
                    System.out.println();
                    userDatabase.printCustomers();
                    System.out.println();
                    break;

                case(6):
                    Scanner custOrEmp = new Scanner(System.in);
                    System.out.print("Do you want to add an Employee or Customer?: ");
                    String input = custOrEmp.nextLine();

                    while (!(input.toLowerCase().equals("employee") ||
                            input.toLowerCase().equals("customer"))) {
                        System.out.print("Invalid input. Please enter EMPLOYEE or CUSTOMER: ");
                        input = custOrEmp.nextLine();
                    }

                    if (input.toLowerCase().equals("employee")) {
                        userDatabase.addEmployee();
                    }

                    if (input.toLowerCase().equals("customer")) {
                        userDatabase.addCustomer();
                    }

                    break;

                case(7):
                    Scanner updateUser = new Scanner(System.in);
                    System.out.print("Update EMPLOYEE or CUSTOMER? ");
                    String updateUserInfo = updateUser.nextLine();

                    while (!(updateUserInfo.toLowerCase().equals("employee") ||
                            updateUserInfo.toLowerCase().equals("customer"))) {
                        System.out.print("Invalid input. Please enter EMPLOYEE or CUSTOMER: ");
                        updateUserInfo = updateUser.nextLine();
                    }

                    Scanner scanID = new Scanner(System.in);
                    if (updateUserInfo.toLowerCase().equals("employee")) {
                        System.out.print("Please enter employee ID: ");
                        int employeeID = scanID.nextInt();
                        userDatabase.updateEmployee(employeeID);
                    }

                    if (updateUserInfo.toLowerCase().equals("customer")) {
                        System.out.print("Please enter customer ID: ");
                        int customerID = scanID.nextInt();
                        userDatabase.updateCustomer(customerID);
                    }

                case(8):
                    transactions.completeTransaction(userDatabase, inventory);
                    break;

                case(9):
                    transactions.printTransactionHistory();
                    System.out.println();
                    break;

            }

        } while (choice != 10);
    }
}
